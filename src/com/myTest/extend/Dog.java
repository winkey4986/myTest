package com.myTest.extend;

public class Dog extends Animal{
	//private String name="¹·";
	public void sound(){
		System.out.println("w~w~¡£¡£ "+name);
		System.out.println("this.name "+this.name+"this.name "+super.name);
	}
	
	public static void main(String[] args) {
		Animal animal = new Dog();
		animal.sound();
	}

}
