package com.myTest.sort;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SortArray {
	//分块保存数据用，每个数据用下标对应位置 置1表示
	private int[] bits = null;
	//长度、也就是最大的数
	private int length;
	//如果有重复的数据，保存重复数值的及其重复次数
	public Map<Integer,Integer> repeatingData = new HashMap<Integer,Integer>();
	//public Map<Integer, Integer> repeatingData = Collections.synchronizedMap(new HashMap<Integer, Integer>());
	//用于设置或者提取int类型的数据的某一位(bit)的值时使用
	private final static int[] bitValue = {
		0x80000000,//10000000 00000000 00000000 00000000      
		0x40000000,//01000000 00000000 00000000 00000000      
		0x20000000,//00100000 00000000 00000000 00000000      
		0x10000000,//00010000 00000000 00000000 00000000      
		0x08000000,//00001000 00000000 00000000 00000000      
		0x04000000,//00000100 00000000 00000000 00000000      
		0x02000000,//00000010 00000000 00000000 00000000      
		0x01000000,//00000001 00000000 00000000 00000000      
		0x00800000,//00000000 10000000 00000000 00000000      
		0x00400000,//00000000 01000000 00000000 00000000      
		0x00200000,//00000000 00100000 00000000 00000000      
		0x00100000,//00000000 00010000 00000000 00000000      
		0x00080000,//00000000 00001000 00000000 00000000      
		0x00040000,//00000000 00000100 00000000 00000000      
		0x00020000,//00000000 00000010 00000000 00000000      
		0x00010000,//00000000 00000001 00000000 00000000		  
		0x00008000,//00000000 00000000 10000000 00000000      
		0x00004000,//00000000 00000000 01000000 00000000      
		0x00002000,//00000000 00000000 00100000 00000000      
		0x00001000,//00000000 00000000 00010000 00000000      
		0x00000800,//00000000 00000000 00001000 00000000      
		0x00000400,//00000000 00000000 00000100 00000000      
		0x00000200,//00000000 00000000 00000010 00000000      
		0x00000100,//00000000 00000000 00000001 00000000      
		0x00000080,//00000000 00000000 00000000 10000000      
		0x00000040,//00000000 00000000 00000000 01000000      
		0x00000020,//00000000 00000000 00000000 00100000      
		0x00000010,//00000000 00000000 00000000 00010000      
		0x00000008,//00000000 00000000 00000000 00001000      
		0x00000004,//00000000 00000000 00000000 00000100      
		0x00000002,//00000000 00000000 00000000 00000010      
		0x00000001 //00000000 00000000 00000000	00000001 			
	};
	//构造一个 “数据块”数组，每个数据块bits[i]的初始值都是00000000 00000000 00000000 00000000 
	public SortArray(int length) {
		if(length < 0){
			throw new IllegalArgumentException("length必须大于零！");
		}
		bits = new int[length / 32 + (length % 32 > 0 ? 1 : 0)];
		this.length = length;
	}
	//取index位的值（0或1）
	public int getBit(int index){
		if(index <0 || index > length){
			throw new IllegalArgumentException("index必须大于零小于" + length);
		}
		int intData = bits[index/32];
		//与对应的bitValue[index%32]进行与运算，数据块中其余位置运算后全置0，当前位由于是和“1”进行与运算，故当前位置值不变。
		//然后再右移相应的位置，获得当前位置的值 0或者1
		return (intData & bitValue[index%32]) >>> (32 - index%32 -1);
	}
	
	//设置index位的值，只能为1
	public void setBit(int index,int value){
		if(index <0 || index > length){
			throw new IllegalArgumentException("index必须大于零小于" + length);
		}		
		if(value!=1){
			throw new IllegalArgumentException("value必须为1");
		}
		//多线程同步有问题，性能和同步会互有牺牲，还没找到很好的解决办法
		//synchronized (bits) {
			//获得对应的数据块，每一个数据块初始值均为为00000000 00000000 00000000 00000000 
			int intData = bits[index/32];
			//将某个数值在其对应数据块中的位置 置1，如十进制数34，在此步运算之后
			// 34/32 = 1  34%32 = 2
			//bits[1] = 00100000 00000000 00000000 00000000 
			//再进来一个数据36，此步运算之后的
			//bits[1] = 00101000 00000000 00000000 00000000 
			bits[index/32] = intData | bitValue[index%32];
		//}
			//保存重复次数
			this.saveCount(index);
	
		
	}
	public int getLength(){
		return length;
	}	
	
	//在map计数器里面保存数字的重复次数，输出的时候用
	public void  saveCount(int index){
		if(this.getBit(index)==1){
			Integer num = repeatingData.get(index);
			 
			if(num==null){
				repeatingData.put(index, 1);
			}else{
				repeatingData.put(index, num+1);
			}
		}
	}
	
	//获取最大的位，主要是为了最后输出的时候，减少循环次数
	public Integer getMaxNum() {
		Integer maxBits;
		Integer maxNum = null;
		int index=0;//bits的下标，代表第几块
		for(int i=bits.length-1;i>=0;i--){
			if(bits[i]==0){
				continue;
			}else{
				index = i;
				break;
			}
		}
		char ch[] = new char[32];
		int index2 = 0;//某一个bits里面的最右边的1的位置
		 int i = 31;
	      while(i >= 0){
	         int temp  = bits[index];
	         temp = temp >> i;
	         ch[32-i-1] = (char) ((temp & 1)+'0');
	         i--;
	      }
	      //System.out.println(ch);
	      for(int k=ch.length-1;k>0;k--){
	    	  if(ch[k]=='1'){
	    		  index2 = k;
	    		  break;
	    	  }
	      }
	      //System.out.println(index2);
	      maxNum = index*32+index2;
		return maxNum;
	}
	
}    
    