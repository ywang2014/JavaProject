package com.map;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {
	public static void main(String[] args) {
		System.out.println(getNullKey());
	}
	
	public static String getNullKey() {
		Map<String, String> map = new HashMap<>();
		return map.get(null);
	}
}
