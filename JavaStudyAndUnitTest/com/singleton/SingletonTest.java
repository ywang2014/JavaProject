package com.singleton;

import java.util.ArrayList;
import java.util.List;

public class SingletonTest extends Thread {

	@Override
	public void run() {
//		System.out.println(this.getName());
		System.out.println(this.getId() + " : " + SingletonFactory.getInstance(1).hashCode());
	}
	
	public static void main(String[] args) {
		List<SingletonTest> threadList = new ArrayList<>(1000);
		for (int i = 0; i < 1000; i++) {
			threadList.add(new SingletonTest());
		}
		
		System.out.println("Start: ");
		for (SingletonTest thread : threadList) {
			thread.start();
		}
	}
}
