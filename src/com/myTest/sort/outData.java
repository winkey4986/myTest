package com.myTest.sort;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class outData {
	public static void main(String[] args) throws IOException {
		BufferedWriter out = new BufferedWriter(new FileWriter("E:\\a.txt"));
		for(int k = 1;k<=9999;k++){
			for(int i = 1;i<=9999;i++){
		    		StringBuffer buf = new StringBuffer(""+i+"");
		    		buf.append(",");
		    		out.write(buf.toString());
			}
		}
		out.flush();
		out.close();
		System.out.println("ok");
	}
}
