package com.myTest.socket.simple;

public class aa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double a = 9000/6630;
		a = (double)(Math.round(9000*100/6630)/100.0);
		int length = (int)Math.ceil(a);
		int length2 = (int)Math.round(9000/6630);
		System.out.println(length);
		System.out.println(length2);
		
		int length3 = (int)Math.ceil(9000/6630.0);
		System.out.println(length3);
		double b = 9000/6630.0;
		System.out.println(b);
	}

}
