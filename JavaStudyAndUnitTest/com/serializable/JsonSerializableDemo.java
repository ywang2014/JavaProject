import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;

public class JsonSerializableDemo {
	public static void main(String[] args) {
		SerializableDemo obj = new SerializableDemo();
		obj.setIsWrapperClass(true);
		obj.setFoundationClass(true);
		obj.setWithoutIs(true);
		obj.setIsWithIs(true);
		System.out.println("Gson: " + getGsonString(obj));
		System.out.println("Fastgson: " + getFastjsonString(obj));
		
		System.out.println(getGsonString(getSerializableDemoByGsonString(getGsonString(obj))));
		System.out.println(getGsonString(getSerializableDemoByGsonString(getFastjsonString(obj))));
		System.out.println(getGsonString(getSerializableDemoByFastgsonString(getGsonString(obj))));
		System.out.println(getFastjsonString(getSerializableDemoByFastgsonString(getGsonString(obj))));
	}
	
	public static String getGsonString(Object obj) {
		return new Gson().toJson(obj);
	}
	
	public static SerializableDemo getSerializableDemoByGsonString(String json) {
		return new Gson().fromJson(json, SerializableDemo.class);
	}
	
	public static String getFastjsonString(Object obj) {
		return JSON.toJSONString(obj);
	}
	
	public static SerializableDemo getSerializableDemoByFastgsonString(String json) {
		return JSON.parseObject(json, SerializableDemo.class);
	}
}
