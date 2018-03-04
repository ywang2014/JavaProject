package com.singleton;

/**
 * �ڲ���̬��ʵ�ֵ���ģʽ
 * 		����JVM����ػ���
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
