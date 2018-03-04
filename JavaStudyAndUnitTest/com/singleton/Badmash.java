package com.singleton;

/**
 * ��ģʽ�ĵ���
 * 	����jvm����ػ��ƣ�ʵ�ֵĶ��̰߳�ȫ
 * 	���������أ������ʵ������Ҫ�ܶ���Դ�������ܽϲ�
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
