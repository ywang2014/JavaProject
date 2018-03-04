package com.singleton;

public class EnumSingletonClassTest{
	public static void main(String[] args) {
		EnumSingleton.INSTANCE.doSomething();
	}
}

enum EnumSingleton {
	INSTANCE;
	
	public void doSomething() {
		System.out.println("singleton is ok");
	}
}