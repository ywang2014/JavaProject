package com.script.engine;

import java.util.HashMap;
import java.util.Map;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Demo {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		ScriptEngineManager manager = new ScriptEngineManager();
		long end = System.currentTimeMillis();
		System.out.println("Time: " + (end - start));
		ScriptEngine engine = manager.getEngineByName("js");
		Map<String, Double> mapData = new Demo().createCollectionMap();
		mapData.forEach(engine::put);
		String condition = "(Price_10+W101+E0001)/capacity*hour";
		try {
			Object result = engine.eval(condition);
			System.out.println(result);
			System.out.println(engine.eval("x < y"));
			System.out.println(engine.eval("x > y"));
			System.out.println(engine.eval("x == y"));
			System.out.println(engine.eval("x != y"));
			Double a = 1.0;
			Double b = 2.0;
			System.out.println(engine.eval(a+"<"+b));
			int c = 1;
			int d = 1;
			System.out.println(engine.eval(c+"=="+d));
		} catch (ScriptException e) {
			e.printStackTrace();
		}
	}
	
	public Map<String, Double> createCollectionMap(){
		Map<String, Double> mapData = new HashMap<String, Double>();
		mapData.put("Price_10", 10d);
		mapData.put("W101", 10d);
		mapData.put("E0001", 10d);
		mapData.put("root", 10d);
		mapData.put("routeNew", 10d);
		mapData.put("capacity", 10d);
		mapData.put("hour", 10d);
		mapData.put("x", 5d);
		mapData.put("y", 6d);
		
		return mapData;
	}
}
