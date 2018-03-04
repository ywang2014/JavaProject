package com.singleton;

/**
 * 恶汉模式的单例
 * 	依赖jvm类加载机制，实现的多线程安全
 * 	不能懒加载，如果类实例化需要很多资源，则性能较差
 * 	
 * @author yong.wang
 *
 */

public class Badmash extends Singleton {
	private static Badmash instance = new Badmash();
	
	private Badmash() {
		// default constructor
	}
	
	public static Badmash getInstance() {
		return instance;
	}
}
