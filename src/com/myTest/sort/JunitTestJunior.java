package com.myTest.sort;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import org.junit.Test;


//单线程测试用例
public class JunitTestJunior {

	@Test
	public void test() throws Exception {
		BufferedReader in = new BufferedReader(new FileReader("E:\\a.txt"));
		BufferedWriter out = new BufferedWriter(new FileWriter("E:\\cc.txt"));
		int readLength = 0;
		char[] chars = new char[1024*8];
		String tail=null;
		String batchData;
		String[] batchDataArr;
		Integer numAsInt;
		//设置最大数字（比文件中最大数据大均可）
		SortArray sortArray = new SortArray(10000);	
		Map<Integer,Integer> map = sortArray.repeatingData;
		try{
			//读数据，已保证数据的完整性
			 while(true){
				readLength = in.read(chars, 0, chars.length);
				//没有读上来数据说明上一次读取数据已读完，不再处理
				if(readLength == 0)
					break;
				boolean isEnd = false;
				//读上来的数据少于数组长度，说明这一次已读完，处理完这次后不再继续读取
				if(readLength < chars.length){
					//System.out.println(String.valueOf(chars).substring(0, readLength));
					batchData = String.valueOf(chars).substring(0, readLength);
					isEnd = true;
				}else{
					//System.out.println(String.valueOf(chars));
					batchData = String.valueOf(chars);
				}
				//接上前一次的剩余数据
				if(tail != null){
					batchData = ""+tail+batchData;
				}
				//截取本次的剩余数据，留到下次用
				tail = batchData.substring(batchData.lastIndexOf(",")+1,batchData.length());
				if(tail.length()==0){
					tail = null;
				}
				batchData = batchData.substring(0,batchData.lastIndexOf(","));
				batchDataArr = batchData.split(",");
				for(String str:batchDataArr){
					numAsInt = Integer.valueOf(str);
					sortArray.setBit(numAsInt, 1);
				}
				if(isEnd==true){
					break;
				}
			}
			//写数据
			Integer sortUnit = sortArray.getMaxNum();
			System.out.println(sortUnit);
			for(int i = 0;i<=sortUnit;i++){
		    	if(sortArray.getBit(i)==1){
		    		StringBuffer buf = new StringBuffer(""+i+"");
		    		buf.append(",");
		    		Integer num = map.get(i);
		    		if(num!=null && num>=2){
		    			for(int j=2;j<=num;j++){
		    				buf.append(""+i+"").append(",");
		    			}
		    		}
		    		out.write(buf.toString());
		    	}				
			}
			out.flush();
		}finally{
			if(in!=null){
	             try{
	            	 in.close();
	             }catch(IOException e){
	            	 e.printStackTrace();
	             }
	        }
	         if(out!=null){
	             try{
	            	 out.close();
	             }catch(IOException e){
	            	 e.printStackTrace();
	             }
	        }
		}
	}

}
