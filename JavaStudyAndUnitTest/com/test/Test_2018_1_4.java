package com.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test_2018_1_4 {

	public static void main(String[] args) {
		System.out.println("modelId=11".indexOf("modelId="));
		
		Test_2018_1_4 obj = new Test_2018_1_4();
		System.out.println("{SUM;PBOM;pbom}/{SUM;PBOM;pbom}".replaceAll("pbom", "abc"));
		System.out.println(obj.replaceStr("1002001001:W20104005,1002001001:W20104002,1002001002:W20103002,1002001002:W20103004,1002001002:W20103005,1002001002:W20103006,1002003001:W20104002,1002003001:W20104003,1002003001:W20104004,1002003001:W20104005,1002001001:W20104004,1002003002:W20103002,1002003002:W20103004,1002003002:W20103005,1002003002:W20103006,1002001001:W20104001,1002003001:W20104001,1002001001:W20104003,1001005001:W20104005,1001005001:W20104006,1001005001:W20104003,1001005001:W20104002,1001005002:W20103006,1001005002:W20103002,1001005002:W20103004,1001005002:W20103005"));
		
		System.out.println(obj.getRuleKeysByStream("SUM    ;   PBOM; pbom"));
		System.out.println(Arrays.asList(obj.getRuleKeysList("SUM    ;   PBOM; pbom")));
		
	}
	
	public String replaceStr(String str) {
		return str.replace(":", "");
	}
	
	public String[] getRuleKeysList(String rule){
        String[] keys = rule.split(";");
        String[] res = new String[keys.length];
        for (int i = 0; i < keys.length; i++){
            res[i] = keys[i].trim();
        }
        return res;
    }
	
	public List<String> getRuleKeysByStream(String rule) {
		return Arrays.stream(rule.split(";")).map(x -> x.trim()).collect(Collectors.toList());
	}
}
