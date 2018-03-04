package com.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinPacking2 {
	public static void main(String[] args){
		List<Box> inputs = new ArrayList<Box>();
		Box a1 = new Box(5,4,5);
		inputs.add(a1);
		Box a2 = new Box(6,4,4);
		inputs.add(a2);
		Box a3 = new Box(6,7,7);
		inputs.add(a3);
		Box a4 = new Box(2,3,4);
		inputs.add(a4);
		Box a5 = new Box(2,8,1);
		inputs.add(a5);
		Box a6 = new Box(7,8,8);
		inputs.add(a6);
		System.out.println(new BinPacking2().algo(inputs).size());
	}
	
	// 逻辑处理算法实现。
	public List<Box> algo(List<Box> inputs){
		// 多级排序
		Collections.sort(inputs);
		int len = inputs.size();
		// 装箱标志位
		int[][] isIncluded = new int[len][];
		for (int i = 0; i < len; i++){
			isIncluded[i] = new int[len];
		}
		
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				isIncluded[i][j] = 0;
			}
		}
		
		for (int i = 1; i < inputs.size(); i++){
			Box currentBox = inputs.get(i);
			for (int j = i-1; j >= 0; j--){
				if (!isIncluded(isIncluded[i], j)){
					Box beforeBox = inputs.get(j);
					if (beforeBox.isSmaller(currentBox)){
						System.out.println(currentBox + " : " + beforeBox);
						isIncluded[i][j] = 1;
						copyIncludeArray(isIncluded[j], isIncluded[i], j);
						if (isFullIncluded(isIncluded[j], j)) {
							break;
						}
					}
				}
			}
			isIncluded[i][i] = countIncludedBoxNumber(isIncluded[i], i);
		}
		
		int maxIndex = 0;
		for (int i = 0; i < len; i++){
			if (maxIndex < isIncluded[i][i]){
				maxIndex = isIncluded[i][i];
			}
		}
		List<Box> resultList = new ArrayList<Box>();
		for (int i = 0; i < maxIndex; i++) {
			if (isIncluded(isIncluded[maxIndex], i)) {
				resultList.add(inputs.get(i));
				System.out.println(inputs.get(i));
			}
		}
		return resultList;
	}
	
	// 是否已经装箱
	private boolean isIncluded(int[] include, int i) {
		return include[i] == 1;
	}
	
	// 是否已经完全装箱：简单优化，完全装箱，则不需要依次遍历前面的箱子了。
	private boolean isFullIncluded(int[] include, int i) {
		return include[i] == i;	// 索引下标是从0开始的，i不需要-1
	}
	
	private void copyIncludeArray(int[] source, int[] dest, int n) {
		for (int i = 0; i < n; i++) {
			if (source[i] == 1) {
				dest[i] = 1;
			}
		}
	}
	
	private int countIncludedBoxNumber(int[] include, int n) {
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (include[i] == 1) {
				count++;
			}
		}
		return count;
	}

	
	public int algo4(List<Box> inputs, List<Box> resultList){
		Collections.sort(inputs);
		
		int len = inputs.size();
		int[] capacity = new int[len];
		for (int i = 0; i < len; i++){
			capacity[i] = 0;
		}
		
		for (int i = 1; i < inputs.size(); i++){
			Box currentBox = inputs.get(i);
			for (int j = i-1; j >= 0; j--){
				Box beforeBox = inputs.get(j);
				if (beforeBox.isSmaller(currentBox)){
					System.out.println(currentBox + " : " + beforeBox);
					capacity[i] += capacity[j] + 1;
					resultList.add(beforeBox);
					inputs.remove(beforeBox);
				}
			}
		}
		
		
		for (Box box : resultList){
			System.out.println(box);
		}
		
		int result = 0;
		for (int i = 0; i < len; i++){
			System.out.println(capacity[i]);
			if (result < capacity[i]){
				result = capacity[i];
			}
		}
		return result;
	}
	
	public int algo2(List<Box> inputs, List<Box> resultList){
		Collections.sort(inputs);
//		for (Box value : inputs){
//			System.out.println(value.toString());
//		}
		
		int len = inputs.size();
		int[] capacity = new int[len];
		for (int i = 0; i < len; i++){
			capacity[i] = 0;
		}
		
		Box minBox = inputs.get(0);
		int index = 0;
		for (int i = 1; i < inputs.size(); i++){
			Box currentBox = inputs.get(i);
			boolean allBigger = true; 
			for (int j = i-1; j >= index; j--){
				Box beforeBox = inputs.get(j);
				if (beforeBox.isSmaller(currentBox)){
					capacity[i] = capacity[j] + 1;
				} else {
					allBigger = false;
				}
			}
		}
		for (Box box : resultList){
			System.out.println(box);
		}
		return capacity[index];
	}
	
	
	

	// 分级排序
	public static boolean cmp(Box a, Box b){
		if (a.x < b.x){
			return true;
		}
		else if (a.x == b.x){
			if (a.y < b.y){
				return true;
			}
			else if (a.y == b.y){
				return a.z <= b.z;
			}
		}
		return false;
	}
}



