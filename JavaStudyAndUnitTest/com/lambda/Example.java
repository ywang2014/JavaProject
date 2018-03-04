package com.lambda;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.swing.JButton;

/*
 * ʹ��lambda���ʽ�滻�����࣬��ʵ��Runnable�ӿ�������������ʾ��
 */
public class Example {
	public static void main(String[] args) {
		Example object = new Example();
		object.testMapAndReduceWithReduce();
	}
	
	public void testRunnable() {
		// Java8 ֮ǰ��ʹ��������ʵ��
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Before Java8");
			}
		}).start();
		
		// Java8֮��ʹ��lambda���ʽ
		new Thread( () -> System.out.println("In java8") ).start();	
	}
	
	
	/*
	 * lambda ���ʽ�����¼�����
	 * �¼�����
	 */
	public void transactionDeal() {
		JButton show = new JButton("Show");
		show.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Event handling without lambda expression is boring");
			}
		});
		
		// Java8
		show.addActionListener( (e) -> {
			System.out.println("Light, Camera, Action!");
		});
	}
	
	/*
	 * lambda���ʽ���б���е���
	 * �����ࣺ���������й���
	 */
	public void iterableList() {
		List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and time");
		for (String fea : features) {
			System.out.println(fea);
		}
		
		// java8
		features.forEach(n -> System.out.println(n));
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////
	/*
	 * ʹ��lambda���ʽ�ͺ���ʽ�ӿ�Predicate
	 * 	Predicate: ֧��Java�ĺ���ʽ���
	 * 	��API��������߼���֧�ָ���Ķ�̬��Ϊ
	 */
	public void predicateFilterTest() {
		List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp", "Python");
		
		System.out.println("Languages with starts with J :");
		filter(languages, (str) -> ((String) str).startsWith("J"));
		
		System.out.println("Languages which ends with a :");
		filter(languages, str -> ((String) str).endsWith("a"));
		
		System.out.println("Print all languages :");
		filter(languages, str -> true);
		
		System.out.println("Print no language :");
		filter(languages, str -> false);
		
		System.out.println("Print language whose length greater than 5 :");
		filter(languages, str -> ((String) str).length() > 5);
	}
	
	private static void filter(List<String> names, Predicate condition) {
		for (String name : names) {
			if (condition.test(name)) {
				System.out.println(name + " ");
			}
		}
	}
	
	// Java 8: ��ʹ��forѭ������ʹ��if���
	private static void filter2(List<String> names, Predicate condition) {
		names.stream().filter(name -> condition.test(name)).forEach(name -> {
			System.out.println(name + " ");
		});
	}
	
	// ������ν�ʺϲ�: and or xor
	private static void filterSomePredicate(List<String> names) {
		Predicate<String> startsWithJ = (n) -> n.startsWith("J");
		Predicate<String> fifthLetterLong = (n) -> n.length() == 5;
		names.stream().
			filter(startsWithJ.and(fifthLetterLong)).
			forEach(n -> System.out.println("nName, which starts with J and fifth letter long is : " + n));
	}
	
	
	/*
	 * Java 8��ʹ��lambda���ʽ��Map��Reduceʾ��
	 * 
	 * �����������Ϊ��֪�ĺ���ʽ��̸���map���������㽫�������ת����
	 * ���磬�� costBeforeTax �б��ÿ��Ԫ��ת����Ϊ˰���ֵ��
	 * �� x -> x*x lambda���ʽ���� map() ���������߽���Ӧ�õ����е�ÿһ��Ԫ�ء�
	 * Ȼ���� forEach() ���б�Ԫ�ش�ӡ������ʹ����API���ռ����࣬���Եõ����к�˰�Ŀ�����
	 * �� toList() �����ķ����� map���κ����������Ľ���ϲ������������ռ������������ն˲��������֮��㲻���������ˡ�
	 * ��������������API�� reduce() �������������ֺϳ�һ������һ�����ӽ��ὲ����
	 * 
	 */
	public void testMapAndReduceWithMap() {
		List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
		for (Integer cost : costBeforeTax) {
			double price = cost + 0.12 * cost;
			System.out.println(price);
		}
		
		// Java8
		costBeforeTax.stream().map(cost -> cost + cost * 0.12).forEach(System.out::println);
	}
	
	/*
	 * map() �������ࣨ�����б�Ԫ�ؽ���ת���ġ�
	 * reduce() ���Խ�����ֵ�ϲ���һ����
	 * Map��Reduce�����Ǻ���ʽ��̵ĺ��Ĳ�����reduce �ֱ���Ϊ�۵�������
	 * reduce ������һ���µĲ��������п����Ѿ���ʹ������SQL������ sum()��avg() ���� count() �ľۼ�������ʵ���Ͼ��� reduce ��������Ϊ���ǽ��ն��ֵ������һ��ֵ��
	 * ��API����� reduce() �������Խ���lambda���ʽ����������ֵ���кϲ���
	 * IntStream�������������� average()��count()��sum() ���ڽ��������� reduce ������Ҳ��mapToLong()��mapToDouble() ��������ת����
	 * �Ⲣ���������㣬��������ڽ�������Ҳ�����Լ����塣
	 * �����Java 8��Map Reduceʾ����������ȶ����м۸�Ӧ�� 12% ��VAT��Ȼ���� reduce() ���������ܺ͡�
	 */
	public void testMapAndReduceWithReduce() {
		List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
		double total = 0;
		for (Integer cost : costBeforeTax) {
			double price = cost * 1.12;
			total += price;
		}
		System.out.println("Total: " + total);
		
		// Java8
		double bill = costBeforeTax.stream().mapToDouble(cost -> cost*1.12).sum();
				//reduce((sum, cost) -> sum + cost).get());
		System.out.println("Total: " + bill);
	}
	
	
	/*
	 * ������Java�������ڴ��ģ�����ϵ�һ�����ò�����������ʹ��lambda���ʽ����API���˴��ģ���ݼ����Ǿ��˵ļ򵥡�
	 * ���ṩ��һ�� filter() ����������һ�� Predicate ���󣬼����Դ���һ��lambda���ʽ��Ϊ�����߼���
	 * �������������lambda���ʽ����Java���ϣ���������⡣
	 * 
	 * ����ʵ�����У������˵�ʱ��ͨ���ᶪ�����֣�filter()�������ǻ��һ���µ��б�����ÿ��Ԫ�ط��Ϲ���ԭ��
	 */
	public void testStreamFilter() {
		List<String> strList = Arrays.asList("Java", "is", "a", "good", "programming", "language");
		List<String> filtered = strList.stream().filter(x -> x.length() > 2).collect(Collectors.toList());
		System.out.printf("Original list : %s, Filtered list : %s", strList, filtered);
	}
	
	/*
	 * ͨ����Ҫ���б��ÿ��Ԫ��ʹ��ĳ��������������һ����ĳ����������ĳ����������������������Щ���������ʺ��� map() ������
	 * ���Խ�ת���߼���lambda���ʽ����ʽ���� map() ������Ϳ��ԶԼ��ϵĸ���Ԫ�ؽ���ת���ˣ�������ʾ��
	 */
	public void testStreamMap() {
		List<String> strList = Arrays.asList("Java", "is", "a", "good", "programming", "language");
		String upperLanguages = strList.stream().map(x -> x.toUpperCase()).collect(Collectors.joining(", "));
		System.out.println(upperLanguages);
	}
	
	/*
	 * ���Ʋ�ͬ��ֵ������һ�����б�
	 * ����չʾ������������� distinct() �������Լ��Ͻ���ȥ��
	 */
	public void testStreamDistinct() {
		List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
		List<Integer> distinct = numbers.stream().map(x -> x*x).distinct().collect(Collectors.toList());
		System.out.printf("Original List : %s,  Square Without duplicates : %s %n", numbers, distinct);
	}
	
	/*
	 * ���㼯��Ԫ�ص����ֵ����Сֵ���ܺ��Լ�ƽ��ֵ
	 * IntStream��LongStream �� DoubleStream ���������У��и��ǳ����õķ������� summaryStatistics()
	 * 	���Է��� IntSummaryStatistics��LongSummaryStatistics ���� DoubleSummaryStatistics��
	 * ��������Ԫ�صĸ���ժҪ���ݡ�
	 * �ڱ����У���������������������б�����ֵ����Сֵ����Ҳ�� getSum() �� getAverage() ����������б������Ԫ�ص��ܺͼ�ƽ��ֵ��
	 */
	public void testStreamSummaryStatistics() {
		List<Integer> primes = Arrays.asList(2, 3, 4, 5, 11, 19, 23);
		IntSummaryStatistics stats = primes.stream().mapToInt(x -> x).summaryStatistics();
		System.out.println("Highest prime number in List : " + stats.getMax());
		System.out.println("Lowest prime number in List : " + stats.getMin());
		System.out.println("Sum of all prime number in List : " + stats.getSum());
		System.out.println("Average of all prime number in List : " + stats.getAverage());
	}
	
	
}