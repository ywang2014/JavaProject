package com.polymorphism;

public abstract class BaseClass {
	public abstract int add(int a, int b);
	
	public int sum(int a, int b) {
		System.out.println("BaseClass sum: start");
		System.out.println("BaseClass sum: end");
		return add(a, b);
	}
	
	public int max(int a, int b) {
		System.out.println("BaseClass max: start");
		System.out.println("BaseClass max: end");
		return a;
	}
}
