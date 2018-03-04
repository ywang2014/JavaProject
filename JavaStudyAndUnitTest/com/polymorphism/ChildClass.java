package com.polymorphism;

public class ChildClass extends BaseClass {

	@Override
	public int add(int a, int b) {
		System.out.println("ChildClass add: start");
		System.out.println("ChildClass add: end");
		return a + b;
	}
	
	@Override
	public int max(int a, int b) {
		System.out.println("ChildClass max: start");
		int c = super.max(a, b);
		System.out.println("ChildClass max: end");
		return sum(c, b);
	}
}
