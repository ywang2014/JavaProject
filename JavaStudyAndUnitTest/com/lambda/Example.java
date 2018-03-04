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
 * 使用lambda表达式替换匿名类，而实现Runnable接口是匿名类的最好示例
 */
public class Example {
	public static void main(String[] args) {
		Example object = new Example();
		object.testMapAndReduceWithReduce();
	}
	
	public void testRunnable() {
		// Java8 之前：使用匿名类实现
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Before Java8");
			}
		}).start();
		
		// Java8之后：使用lambda表达式
		new Thread( () -> System.out.println("In java8") ).start();	
	}
	
	
	/*
	 * lambda 表达式进行事件处理
	 * 事件监听
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
	 * lambda表达式对列表进行迭代
	 * 集合类：迭代、并行过滤
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
	 * 使用lambda表达式和函数式接口Predicate
	 * 	Predicate: 支持Java的函数式编程
	 * 	向API方法添加逻辑，支持更多的动态行为
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
	
	// Java 8: 不使用for循环，不使用if语句
	private static void filter2(List<String> names, Predicate condition) {
		names.stream().filter(name -> condition.test(name)).forEach(name -> {
			System.out.println(name + " ");
		});
	}
	
	// 多条件谓词合并: and or xor
	private static void filterSomePredicate(List<String> names) {
		Predicate<String> startsWithJ = (n) -> n.startsWith("J");
		Predicate<String> fifthLetterLong = (n) -> n.length() == 5;
		names.stream().
			filter(startsWithJ.and(fifthLetterLong)).
			forEach(n -> System.out.println("nName, which starts with J and fifth letter long is : " + n));
	}
	
	
	/*
	 * Java 8中使用lambda表达式的Map和Reduce示例
	 * 
	 * 本例介绍最广为人知的函数式编程概念map。它允许你将对象进行转换。
	 * 例如，将 costBeforeTax 列表的每个元素转换成为税后的值。
	 * 将 x -> x*x lambda表达式传到 map() 方法，后者将其应用到流中的每一个元素。
	 * 然后用 forEach() 将列表元素打印出来。使用流API的收集器类，可以得到所有含税的开销。
	 * 有 toList() 这样的方法将 map或任何其他操作的结果合并起来。由于收集器在流上做终端操作，因此之后便不能重用流了。
	 * 你甚至可以用流API的 reduce() 方法将所有数字合成一个，下一个例子将会讲到。
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
	 * map() 将集合类（例如列表）元素进行转换的。
	 * reduce() 可以将所有值合并成一个。
	 * Map和Reduce操作是函数式编程的核心操作，reduce 又被称为折叠操作。
	 * reduce 并不是一个新的操作，你有可能已经在使用它。SQL中类似 sum()、avg() 或者 count() 的聚集函数，实际上就是 reduce 操作，因为它们接收多个值并返回一个值。
	 * 流API定义的 reduce() 函数可以接受lambda表达式，并对所有值进行合并。
	 * IntStream这样的类有类似 average()、count()、sum() 的内建方法来做 reduce 操作，也有mapToLong()、mapToDouble() 方法来做转换。
	 * 这并不会限制你，你可以用内建方法，也可以自己定义。
	 * 在这个Java 8的Map Reduce示例里，我们首先对所有价格应用 12% 的VAT，然后用 reduce() 方法计算总和。
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
	 * 过滤是Java开发者在大规模集合上的一个常用操作，而现在使用lambda表达式和流API过滤大规模数据集合是惊人的简单。
	 * 流提供了一个 filter() 方法，接受一个 Predicate 对象，即可以传入一个lambda表达式作为过滤逻辑。
	 * 下面的例子是用lambda表达式过滤Java集合，将帮助理解。
	 * 
	 * 在现实生活中，做过滤的时候，通常会丢弃部分，filter()方法则是获得一个新的列表，且其每个元素符合过滤原则
	 */
	public void testStreamFilter() {
		List<String> strList = Arrays.asList("Java", "is", "a", "good", "programming", "language");
		List<String> filtered = strList.stream().filter(x -> x.length() > 2).collect(Collectors.toList());
		System.out.printf("Original list : %s, Filtered list : %s", strList, filtered);
	}
	
	/*
	 * 通常需要对列表的每个元素使用某个函数，例如逐一乘以某个数、除以某个数或者做其它操作。这些操作都很适合用 map() 方法，
	 * 可以将转换逻辑以lambda表达式的形式放在 map() 方法里，就可以对集合的各个元素进行转换了，如下所示。
	 */
	public void testStreamMap() {
		List<String> strList = Arrays.asList("Java", "is", "a", "good", "programming", "language");
		String upperLanguages = strList.stream().map(x -> x.toUpperCase()).collect(Collectors.joining(", "));
		System.out.println(upperLanguages);
	}
	
	/*
	 * 复制不同的值，创建一个子列表
	 * 本例展示了如何利用流的 distinct() 方法来对集合进行去重
	 */
	public void testStreamDistinct() {
		List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
		List<Integer> distinct = numbers.stream().map(x -> x*x).distinct().collect(Collectors.toList());
		System.out.printf("Original List : %s,  Square Without duplicates : %s %n", numbers, distinct);
	}
	
	/*
	 * 计算集合元素的最大值、最小值、总和以及平均值
	 * IntStream、LongStream 和 DoubleStream 等流的类中，有个非常有用的方法叫做 summaryStatistics()
	 * 	可以返回 IntSummaryStatistics、LongSummaryStatistics 或者 DoubleSummaryStatistics，
	 * 描述流中元素的各种摘要数据。
	 * 在本例中，我们用这个方法来计算列表的最大值和最小值。它也有 getSum() 和 getAverage() 方法来获得列表的所有元素的总和及平均值。
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