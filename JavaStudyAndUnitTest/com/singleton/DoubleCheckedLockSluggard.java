package com.singleton;

/**
 * 懒汉单例模式 -- 双重锁检查
 * 	 synchronized是锁代码块, 减小了锁范围，仅创建对象前，才可能执行锁动作，
 * 	 getInstance通常不执行锁，效率较高.
 * 
 * 
 * @author yong.wang
 *
 */

public class DoubleCheckedLockSluggard extends Singleton {
	private static DoubleCheckedLockSluggard instance;
	
	private DoubleCheckedLockSluggard() {
		// default constructor
	}

	public static DoubleCheckedLockSluggard getInstance() {
		if (instance == null) {
			synchronized(DoubleCheckedLockSluggard.class) {
				if (instance == null) {
					instance = new DoubleCheckedLockSluggard();
				}
				return instance;
			}
		}
		return null;
	}
}
