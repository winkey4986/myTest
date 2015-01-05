package com.myTest.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 多线程 字符流
 * @author winkey
 *
 */
public class MyThreadBufferedReader implements Runnable{
	public static BufferedReader in;
	public static BufferedWriter out;
	public static SortArray sortArray;
	
	public MyThreadBufferedReader(BufferedReader in,BufferedWriter out,Integer length){
		this.in = in;
		this.out = out;
		this.sortArray= new SortArray(length);
	}
	
    public void run(){   
    	try {
			
			String[] batchDataArr;
			Integer numAsInt;
			String line = null;
			// bb.txt里的数据是
			// 13,6,67,28,15,2,6,50,23,67,89,72,.....(后面数据跟前面类似，逗号隔开的整数)
			// 问题：怎样每次读1000个逗号的数据？？？？？？？？？？？？？？？？？？？？？？？？
			while ((line = in.readLine()) != null) {
				String batchData = line;
				System.out.println(Thread.currentThread().getName()+"___"+batchData);
				batchDataArr = batchData.split(",");
				for (String str : batchDataArr) {
					numAsInt = Integer.valueOf(str);
					sortArray.setBit(numAsInt, 1);
				}
			}

		}catch (Exception e) {
			e.printStackTrace();
		}/*finally{
			//关闭流
	         if(in!=null){
	             try{
	            	 in.close();
	             }catch(IOException e){
	            	 e.printStackTrace();
	             }
	        }
	     }*/   
    } 
    
    public static void main(String[] args) throws Exception {    
		MyThreadBufferedReader mt=new MyThreadBufferedReader(new BufferedReader(new FileReader("E:\\bbb.txt")),
				new BufferedWriter(new FileWriter("E:\\cc.txt")),
				100000000); 
		new Thread(mt).start();
		new Thread(mt).start();
		new Thread(mt).start();
		new Thread(mt).start();
		Integer sortUnit = sortArray.getMaxNum();
		System.out.println(Thread.currentThread().getName()+"__MaxNum__"+sortUnit);
		for (int i = 0; i <= sortUnit; i++) {
			if (sortArray.getBit(i) == 1) {
				StringBuffer buf = new StringBuffer("" + i + "");
				buf.append(",");
				Integer num = sortArray.repeatingData.get(i);
				if (num != null && num >= 2) {
					for (int j = 2; j <= num; j++) {
						buf.append("" + i + "").append(",");
					}
				}
				out.write(buf.toString());
			}
		}
		in.close();
		out.flush();
		out.close();
    }
}
