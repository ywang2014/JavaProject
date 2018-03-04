package com.lambda;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

import com.test.model.ModelObject;

public class ListToMap {
	private List<ModelObject> list;
	
	public ListToMap(){
		list = new ArrayList<>(4);
		list.add(new ModelObject(1, "first", 90d, 1000d));
		list.add(new ModelObject(2, "second", 88d, 1200d));
		list.add(new ModelObject(3, "third", 92d, 900d));
		list.add(new ModelObject(4, "fourth", 80d, 1000d));
	}
	
	public static void main(String[] args) {
		ListToMap obj = new ListToMap();
		obj.getMap();
	}

	public void getMap() {
		System.out.println("-------------------------------------------------------------");
		list.stream().collect(Collectors.toMap(ModelObject::getObjectId, ModelObject::getObjectName)).forEach((x, y) -> {
			System.out.println(x + ": " + y);
		});
		
		System.out.println("-------------------------------------------------------------");
		// 重复key，解决办法
		list.stream().collect(Collectors.toMap(x -> x.getSalary(), x -> x.getObjectName(), 
				(oldValue, newValue) -> oldValue)).forEach((x, y) -> {
					System.out.println(x + ": " + y);
				});
		
		System.out.println("-------------------------------------------------------------");
		// 有序的list
		list.stream().collect(Collectors.toMap(x -> x.getObjectName(), x -> x.getScore())).forEach(
				(x, y) -> { 
					System.out.println(x + ": " + y);
				});
		
		System.out.println("");
		list.stream().collect(Collectors.toMap(
				x -> x.getObjectName(), 
				x -> x.getScore(), 
				(oldValue, newValue) -> oldValue,
				LinkedHashMap::new)
		)
		.forEach(
				(x, y) -> { 
					System.out.println(x + ": " + y);
				});
		
	}
}
