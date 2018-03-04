package com.singleton;

/**
 * 懒汉单例模式
 * 	 synchronized是锁方法, 当两个线程都要进入getInstance()时, 只有一个能进入, 并创建出实例, 
 *   然后另外一个进入后, 判断 instace不为null, 然后直接得到instance. 这种做法是没有错误的. 
 *   但是由于线程都需要通过getInstance()来获取对象, 所以getInstance()调用频率很高, 
 *   所以线程被锁的频率也很高, 所以这种做法效率低.
 * 
 * 
 * @author yong.wang
 *
 */

public class Sluggard extends Singleton {
	private static Sluggard instance;
	
	private Sluggard() {
		// default constructor
	}
	
	public static synchronized Sluggard getInstance() {
		if (instance == null) {
			instance = new Sluggard();
		}
		return instance;
	}

}
