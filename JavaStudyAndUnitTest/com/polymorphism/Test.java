package com.polymorphism;

public class Test {

	public static void main(String[] args) {
		BaseClass object = new ChildClass();
		int a = 1;
		int b = 2;
		System.out.println(object.sum(a, b));
		System.out.println(object.max(a, b));
		
		//object = new BaseClass();
		
	}
}
