package com.singleton;

/**
 * 单例模式：枚举法实现
 * 
 * @author yong.wang
 *
 */

public class EnumSingletonFactory {
	private EnumSingletonFactory() {
		// default constructor
	}
	
	public static EnumSingletons getInstance() {
		return EnumSingletonCase.INSTANCE.getInstanc();
	}
	
	private enum EnumSingletonCase {
		INSTANCE;
		
		private EnumSingletonCase() {
			instance = new EnumSingletons();
		}
		
		private EnumSingletons instance;
		
		public EnumSingletons getInstanc() {
			return instance;
		}
	}
}

class EnumSingletons extends Singleton {
	
}


