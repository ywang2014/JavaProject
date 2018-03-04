package com.script.engine;

import java.util.List;

import javax.script.Compilable;
import javax.script.CompiledScript;
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;

public class ScriptEngineStudy {
	public static void main() {
		ScriptEngineStudy obj = new ScriptEngineStudy();
	}
	
	public void getListScriptEngine() {
		ScriptEngineManager manager = new ScriptEngineManager();
		List<ScriptEngineFactory> factories = manager.getEngineFactories();
		factories.forEach(x -> {
			System.out.printf("Name: %s\n" + "Version: %s\n" + 
					"Language name: %s\n" + "Language version: %s\n" +
					"Extensions: %s\n" +
					"Mime types: %s\n" +
					"Names: %s\n",
					x.getEngineName(), x.getEngineVersion(),
					x.getLanguageName(), x.getLanguageVersion(),
					x.getExtensions(),
					x.getMimeTypes(),
					x.getNames());
		});
	}
	
	// 生成脚本引擎：根据扩展名，根据Mime类型，根据名称
	public ScriptEngine getScriptEngine() {
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("javascript");
		ScriptEngine engineByExtension = manager.getEngineByExtension("js");
		ScriptEngine engineByMimeType = manager.getEngineByMimeType("text/javascript");
		return engine;
	}
	
	public void demoScriptEngine() {
		ScriptEngine engine = getScriptEngine();
		try {
			Double hour = (Double)engine.eval("var date = new Date(); date.getHours();");
			System.out.println(hour);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void reverseStringByScriptEngine() {
		ScriptEngine engine = getScriptEngine();
		try {
			engine.put("name", "JavaLanguage");
			engine.eval(
					"var output = ''; for (i = 0; i <= name.length; i++) { output = name.charAt(i) + output }"
					);
			String name = (String)engine.get("output");
			System.out.println(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 让脚本运行得更快：解析运行慢 --> 编译运行
	 */
	public void compileScript() {
		ScriptEngine engine = getScriptEngine();
		engine.put("counter", 0);
		if (engine instanceof Compilable) {
			Compilable compileEngine = (Compilable)engine;
			try {
				CompiledScript script = compileEngine.compile("function count() { counter = counter + 1; return counter;}; count();");
				System.out.printf("Counter: %s\n", script.eval());
				System.out.printf("Counter: %s\n", script.eval());
				System.out.printf("Counter: %s\n", script.eval());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 动态调用脚本语言
	 */
	public void invocableScript() {
		ScriptEngine engine = getScriptEngine();
		if (engine instanceof Invocable) {
			try {
				engine.eval(
						"function reverse(name) { var output = ''; for (i = 0; i <= name.length; i++) { output = name.charAt(i) + output; } return output; }"
						);
				Invocable invokeEngine = (Invocable)engine;
				Object obj = invokeEngine.invokeFunction("reverse", "abcdef");
				System.out.println(obj);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	

}
