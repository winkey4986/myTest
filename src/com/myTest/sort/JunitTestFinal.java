package com.myTest.sort;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

//多线程测试用例
public class JunitTestFinal {

	@Test
	public void test() throws Exception {
		BufferedReader in = new BufferedReader(new FileReader("E:\\a.txt"));
		BufferedWriter out = new BufferedWriter(new FileWriter("E:\\cc.txt"));
		int readLength = 0;
		char[] chars = new char[1024*8];
		String tail=null;
		String batchData;
		
		try{
			//创建一个可重用固定线程数的线程池
			ExecutorService pool = Executors.newFixedThreadPool(4);//两个子线程
			//读入文件
			 while(true){
				readLength = in.read(chars, 0, chars.length);
				//没有读上来数据说明上一次读取数据已读完，不再处理
				if(readLength == 0)
					break;
				boolean isEnd = false;
				//读上来的数据少于数组长度，说明这一次已读完，处理完这次后不再继续读取
				if(readLength < chars.length){
					batchData = String.valueOf(chars).substring(0, readLength);
					isEnd = true;
				}else{
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
				String[] batchDataArr = new String[batchData.split(",").length];//多线程处理这个东西！！！
				batchDataArr = batchData.split(",");
				MyThread mt1 = new MyThread(batchDataArr);
				pool.execute(mt1);
				if(isEnd==true){
					break;
				}
			}
			//关闭线程用
			pool.shutdown();//只是不能再提交新任务，等待执行的任务不受影响  
			try {
				boolean loop = true;
				do { // 等待所有任务完成
					loop = !pool.awaitTermination(100, TimeUnit.MILLISECONDS); // 阻塞，直到线程池里所有任务结束
				} while (loop);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//输出文件
			Integer sortUnit = MyThread.sortArray.getMaxNum();
			System.out.println("最大数为：     "+sortUnit);
			for(int i = 0;i<=sortUnit;i++){
		    	if(MyThread.sortArray.getBit(i)==1){
		    		StringBuffer buf = new StringBuffer(""+i+"");
		    		buf.append(",");
		    		Integer num = MyThread.sortArray.repeatingData.get(i);
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
