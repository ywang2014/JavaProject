package com.singleton;

/**
 * ��������ģʽ
 * 	 synchronized��������, �������̶߳�Ҫ����getInstance()ʱ, ֻ��һ���ܽ���, ��������ʵ��, 
 *   Ȼ������һ�������, �ж� instace��Ϊnull, Ȼ��ֱ�ӵõ�instance. ����������û�д����. 
 *   ���������̶߳���Ҫͨ��getInstance()����ȡ����, ����getInstance()����Ƶ�ʺܸ�, 
 *   �����̱߳�����Ƶ��Ҳ�ܸ�, ������������Ч�ʵ�.
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
