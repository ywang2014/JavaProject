package com.regular;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularDemo {
	public static void main(String[] args) {
		RegularDemo obj = new RegularDemo();
		System.out.println(obj.split("1+1-1", "[+-]"));
		System.out.println(obj.match("1+aaa1-1bbb", "\\w+([\\+\\-\\*\\/]\\w+)+"));
		System.out.println(obj.regexMatches("1+abv", "\\+|\\-|\\*|/"));
		System.out.println(obj.regexMatches("/", "[\\+\\-\\*/]"));
	}
	
	public List<String> split(String source, String separator) {
		if (source == null || separator == null) {
			return new ArrayList<>();
		}
		return Arrays.asList(source.split(separator));
	}
	
	public boolean match(String source, String matcher) {
		if (source == null || matcher == null) {
			return false;
		}
		return source.matches(matcher);
	}
	
	public boolean regexMatches(String source, String regex) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(source);
		return matcher.find();
	}
}
