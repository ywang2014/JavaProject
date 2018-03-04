package com.singleton;

/**
 * ��������ģʽ -- ˫�������
 * 	 synchronized���������, ��С������Χ������������ǰ���ſ���ִ����������
 * 	 getInstanceͨ����ִ������Ч�ʽϸ�.
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
