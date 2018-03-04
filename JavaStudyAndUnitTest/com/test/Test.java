package com.test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.wltea.expression.ExpressionEvaluator;  
import org.wltea.expression.PreparedExpression;  
import org.wltea.expression.datameta.Variable; 

public class Test {
	public static void main(String[] args){
		Test object = new Test();
		object.testStringContains();
		
		object.testIntegerParseInt();
		
		Test t = new Test();
		System.out.println(t.getReturnString("ok", "10000", "ok"));
		
		t.testRegexExpression();
		
		t.getExpressionValue();
		
		System.out.println(t.parseAttributeKey("123<=5"));
		
		t.testSplit(",1,1,2,3,,,4,5,,,");
		
		List<Integer> a = t.getIntSouceModelIdsByString(",1,1,2,3,,,4,5,,,");
		
		String str = ",1,1,2,3,,,4,5,,,";
		System.out.println(str.replaceFirst(",1,", ",3,"));
		
		System.out.println(t.testReplaceAll("abc/abc\\\\%*a:a?dc/:*?\"<>|.xls"));
		System.out.println(t.getCountByPlanType("  12 * 1 +   a * 3-4"));
		
	}
	
	public String getReturnString(Object result, String code, String message) {
		return "{\"Result\":\"" + result + "\", \"Code\":\"" + code + "\", \"Message\":\"" + message + "\"}";
	}
	
	public void testRegexExpression() {
		String s = "F0120BF0201";
		// "\\d+(\\.\\d+)?$"
		Pattern patternEnd = Pattern.compile("\\d+$");
        Matcher matcherEnd = patternEnd.matcher(s);
        
        if(matcherEnd.find()){
            System.out.println(matcherEnd.group());
        }
        
        String regex = "(\\d+).*";
        String regex2 = "\\d*";
        String regex3 = "^([^\\_\\-\\s]+)[\\_\\-\\s].*$";
        String str = "abc2d";
        str = ".02";
        String str2 = "";
        Pattern p = Pattern.compile(regex2);
        Matcher m =p.matcher(str);
        String value = null;
        if (m.find()) {
        	value = m.group();
        }
        String test = m.group();
        System.out.println(value);
        System.out.println(test);
        
        String regex4 = "[A-Za-z]+";
        String str4 = "1234";
        Pattern p4 = Pattern.compile(regex4);
        Matcher m4 =p4.matcher(str4);
        String value4 = "";
        if (m4.find()) {
        	value4 = m4.group();
        }
        System.out.println(value4);
        
        
        String regex5 = "[A-Za-z]+";
        String str5 = "1234";
        Pattern p5 = Pattern.compile(regex5);
        Matcher m5 =p5.matcher(str5);
        String value5 = "";
        if (m5.find()) {
        	value5 = m5.group();
        }
        System.out.println(value5);
	}
	
	public void getExpressionValue() {
		//定义表达式  
        String expression = "(a > 1 || b < 2) && c < 3 ";  
        //给表达式中的变量 [版本] 付上下文的值  
        List<Variable> variables = new ArrayList<Variable>();  
        variables.add(Variable.createVariable("a", 2));  
        variables.add(Variable.createVariable("b", 2));  
        variables.add(Variable.createVariable("c", 2));  
        //预编译表达式  
        PreparedExpression pe = ExpressionEvaluator.preparedCompile(expression, variables);  
        //执行表达式  
        Object result = pe.execute();  
        System.out.println("Result = " + result);  
        
        //混合运算  
        String resultStr = "(1 + 2) - 4 * 3 + 2 / 2 + 4%3";  // 2^2
        System.out.println(ExpressionEvaluator.evaluate(resultStr));  
	}
	
	public void testStringContains() {
		String a = "xxx|";
		String b = "xxx;";
		String c = "|";
		String d = ";";
		
		boolean b1 = a.contains(c);
		boolean b2 = b.contains(d);

		System.out.println(b1);
		System.out.println(b2);
	}
	
	public void testIntegerParseInt() {
		String a = "1";
		String b = "1.0";
		String c = "1a";
		String d = "aa";
		String e = "0.1";
		String f = "中午";
		
		Integer a1 = Integer.parseInt(a);
//		Integer b1 = Integer.parseInt(b);
//		Integer c1 = Integer.parseInt(c);
//		Integer d1 = Integer.parseInt(d);
//		Integer e1 = Integer.parseInt(e);
//		Integer f1 = Integer.parseInt(f);
	}
	
	public String parseAttributeKey(String expression){
        int index = expression.indexOf('=');
        if (index == -1){
            return "";
        }
        return expression.substring(0, index);
    }
	
	public void testSplit(String str) {
		String[] res = str.split(",");
		for (String s : res) {
			System.out.println(s);
		}
	}
	
	public List<Integer> getIntSouceModelIdsByString(String str){
        List<Integer> intIds = new ArrayList<>();
        if (str == null){
            return intIds;
        }

        String[] ids = str.split(",");
        for (String id : ids){
            Integer value;
            try{
                value = Integer.parseInt(id);
                intIds.add(value);
            }
            catch (Exception e){
                //TODO
            }
        }
        return intIds;
    }
	
	public String testReplaceAll(String str) {
		//String reg2 = "[`~!@#$%^&*()+=|{}':;',\\[\\]<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]"; 
		String reg2 = "[/\\:*?\"<>|\\\\]";
		return str.replaceAll(reg2, "_");
	}
	
	public String testMap(String str) {
		Map<String, String> aMap = new HashMap<String, String>();
		aMap.put("1", "2");
		Map<String, String> bMap = new HashMap<String, String>();
		bMap.put("2", "3");
		return bMap.get(aMap.get(str));
	}
	
	private Double stringToDouble(String str){
        try{
            return Double.parseDouble(str);
        }
        catch (Exception e){
            return null;
        }
    }
	
	public Integer getCountByPlanType(String type){
        int result = 0;
        String[] itemTypes = type.split("[+]");
        for (String item : itemTypes){
            String[] items = item.split("[*]");
            if (items.length == 2){
                Double res = stringToDouble(items[0]);
                result += res == null ? 0 : res.intValue();
            }
        }
        return result;
    }
	
}
