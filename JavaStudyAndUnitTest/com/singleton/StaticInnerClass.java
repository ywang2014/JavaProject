package com.singleton;

/**
 * 内部静态类实现单例模式
 * 		利用JVM类加载机制
 * 
 * @author yong.wang
 *
 */

public class StaticInnerClass extends Singleton {
	private static class InnerSingleton {
		private static StaticInnerClass instance = new StaticInnerClass();
	}
	
	private StaticInnerClass() {
		// default constructor
	}
	
	public static StaticInnerClass getInstance() {
		return InnerSingleton.instance;
	}
}
