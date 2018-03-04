package com.test;
/**
 * 2017.10.17
 * @author yong.wang
 *
 */
public class Test_2 {
	public Test_2() {
		// default 
	}
	
	public Test_2(Integer a) {
		System.out.println(a);
	}
	
	public Test_2(Integer a, double b) {
		System.out.println(a);
		System.out.println(b);
	}

	public static void main(String[] args){
		Test_2 object = new Test_2();
		System.out.println(object.stringToDouble("3009"));
		//System.out.println(object.getDoubleStringWith2Decimals(22222222222.111d));
		//object.testStrmatches();
		System.out.println(object.getFormatString(0.01d, null));
		//System.out.println(Double.parseDouble(null));
		//System.out.println(Double.parseDouble("0"));
		//object.testJavaArray();
		
		System.out.println(Integer.valueOf(" 123 ".trim()));
		System.out.println("aawddeW".indexOf('W'));
		
	}
	
	public Double stringToDouble(String str) {
		Boolean strResult = str.matches("-?[0-9]+\\.?[0-9]*");  
		if (strResult) {
			return Double.valueOf(str);
		}
		return null;
	}
	
	public void testStrmatches() {
		String[] str = {"a", "1", ".", ",", "_", "Z", "\n", "\t", "\\"};
		String reg = "\\w";
		for (int i = 0; i < str.length; i++) {
			System.out.println(str[i].matches(reg));
		}
		
		String emailReg = "\\w+.\\w+.\\w";
	}
	
	public String getDoubleStringWith2Decimals(Double value){
        if (value == null){
            return null;
        }
        return String.format("%.2f", value);
    }
	
	public String getFormatString(Double a, Double b) {
		return String.format("The dividend is %f  and divisor is %f", a, b);
	}
	
	// 测试Java的数组，是否和C/C++一样，使用的是引用类型：函数类别可以修改数组的值
	public void testJavaArray() {
		System.out.println("\n----------测试Java的数组-------------");
		String[] a = {"1", "2", "3"};
		String[] b = new String[3];
		int[] c = {1, 2, 3};
		modifyArray(a, b, c);
		for (int i = 0; i < a.length; i++) {
			System.out.println(String.format("a[%d]:%s, b[%d]:%s, c[%d]:%d", i, a[i], i, b[i], i, c[i]));
		}
	}
	
	private void modifyArray(String[] a, String[] b, int[] c) {
		for (int i = 0; i < a.length; i++) {
			a[i] += 1;
			b[i] += 1;
			c[i] += 1;
		}
	}
}
