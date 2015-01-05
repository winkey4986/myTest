package com.myTest.sort;

public class MyThreadDemo implements Runnable{
	private int ticket=10;    
    public void run(){    
        for(int i=0;i<20;i++){    
            if(this.ticket>0){    
            System.out.println(Thread.currentThread().getName()+"卖票：ticket"+this.ticket--);    
            }    
        }    
    } 
    
    public static void main(String[] args) {    
        MyThreadDemo mt=new MyThreadDemo();    
        new Thread(mt).start();//同一个mt，但是在Thread中就不可以，如果用同一    
        new Thread(mt).start();//个实例化对象mt，就会出现异常    
        new Thread(mt).start();    
    } 
}
