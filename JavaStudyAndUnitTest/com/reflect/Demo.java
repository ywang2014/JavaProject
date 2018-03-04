import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 使用反射方式，实现动态调用方法
 * 
 * @author yong.wang
 *
 */
public class Demo {
	private String property;
	private String name;
	private Double value;
	
	public static void main(String[] args) {
		Demo test = new Demo();
		test.setName("name");
		test.setProperty("property");
		
		Demo test2 = new Demo();
		test2.setName("name2");
		test2.setProperty("property2");
		
		Demo test3 = new Demo();
		test3.setName("name3");
		test3.setProperty("property3");
		
		try {
			Demo obj = new Demo();
			System.out.println(obj.invokeMethod("Demo", "getName", test));
			System.out.println(obj.invokeMethod("Demo", "getProperty", test2));
			System.out.println(obj.getFieldValueByName("property", test3));
			obj.setFieldValueWithFieldName("setValue", test3, 1.112);
			System.out.println(test3.getValue());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 调用任意类的任意方法
	public String invokeMethod(String className, String methodName, Object obj) throws Exception{
		Class<?> clazz = Class.forName(className);
		Method method = clazz.getDeclaredMethod(methodName);
		return (String)method.invoke(obj);
	}
	
	// 根据属性名称获取属性值
	public Object getFieldValueByName(String fieldName, Object obj) {
		try {
			String getter = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
			Method method = obj.getClass().getDeclaredMethod(getter);
			return method.invoke(obj);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	// 设值
	public void setFieldValueWithFieldName(String methodName, Object obj, Double value) {
		try {
			Method method = obj.getClass().getDeclaredMethod(methodName, Double.class);
			method.setAccessible(true);
			method.invoke(obj, value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 获取属性名称、类型、值的map数组
	public List<Map<String, Object>> getFeildInfos(Object obj){
		Field[] fields = obj.getClass().getDeclaredFields();
		List<Map<String, Object>> listMap = new ArrayList<>();
		for (int i = 0; i < fields.length; i++) {
			Map<String, Object> map = new HashMap<>();
			map.put("name", fields[i].getName());
			map.put("type", fields[i].getType());
			map.put("value", getFieldValueByName(fields[i].getName(), obj));
			listMap.add(map);
		}
		return listMap;
	}
	
	public String getProperty() {
		return property;
	}
	public void setProperty(String property) {
		this.property = property;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}
}
