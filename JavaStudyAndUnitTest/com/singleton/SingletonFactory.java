package com.singleton;

public class SingletonFactory {

	public static Singleton getInstance(int type) {
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		switch (type) {
			case 1:
				return Badmash.getInstance();
			case 2:
				return Sluggard.getInstance();
			case 3:
				return DoubleCheckedLockSluggard.getInstance();
			case 4:
				return StaticInnerClass.getInstance();
			case 5:
				return EnumSingletonFactory.getInstance();
			default:
				return null;
		}
	}
}
