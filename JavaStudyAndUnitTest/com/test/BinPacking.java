package com.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Box implements Comparable<Box> {
	int x;
	int y;
	int z;
	
	public Box(int x, int y, int z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	// �༶����x,y,z
	public int compareTo(Box b) {
		if (this.x < b.x){
			return -1;
		}
		else if (this.x == b.x){
			if (this.y < b.y){
				return -1;
			}
			else if (this.y == b.y){
				if (this.z < b.z){
					return -1;
				}
				else if (this.z == b.z){
					return 0;
				}
			}
		}
		return 1;
    }
	
	// �ж��Ƿ����װ��
	public boolean isSmaller(Box b){
		return this.x <= b.x && this.y <= b.y && this.z <= b.z;
	}
	
	public String toString(){
		return "x=" + x + ", y=" + y + ", z=" + z;
	}
}

public class BinPacking {
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
		Box a5 = new Box(6,4,9);
		inputs.add(a5);
		Map<Box, List<Box>> boxMap = new BinPacking().algo(inputs);
		for (Map.Entry<Box, List<Box>> entry : boxMap.entrySet()) {
			Box biggerBox = entry.getKey();
			List<Box> boxes = entry.getValue();
			System.out.println("�ڲ�������Ŀ�� " + boxes.size());
			System.out.println("��������ӣ�" + biggerBox);
			for (Box box : boxes) {
				System.out.println("        �ڲ����ӣ�" + box);
			}
		}
	}
	
	// �߼������㷨ʵ�֡�
	public Map<Box, List<Box>> algo(List<Box> inputs){
		// �༶����
		Collections.sort(inputs);
		int len = inputs.size();
		// װ���־λ
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
						// �˴�ʵ�ʴ�ӡ�ľ�������֮���װ���߼������Կ����������ӿ���װ����Щ��������ӡ�
						// System.out.println(currentBox + " : " + beforeBox);
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
		
		int maxNumber = 0;	// �˴�֮ǰ��bug����index��װ������Ū�����ˡ�
		for (int i = 0; i < len; i++){
			if (maxNumber < isIncluded[i][i]){
				maxNumber = isIncluded[i][i];
			}
		}
		
		Map<Box, List<Box>> resultMap = new HashMap<Box, List<Box>>();
		for (int i = 0; i < len; i++){
			if (maxNumber == isIncluded[i][i]){
				List<Box> boxList = new ArrayList<Box>();
				for (int j = 0; j < i; j++) {
					if (isIncluded(isIncluded[i], j)) {
						boxList.add(inputs.get(j));
					}
				}
				resultMap.put(inputs.get(i), boxList);
			}
		}
		return resultMap;
	}
	
	// �Ƿ��Ѿ�װ��
	private boolean isIncluded(int[] include, int i) {
		return include[i] == 1;
	}
	
	// �Ƿ��Ѿ���ȫװ�䣺���Ż�����ȫװ�䣬����Ҫ���α���ǰ��������ˡ�
	private boolean isFullIncluded(int[] include, int i) {
		return include[i] == i;	// �����±��Ǵ�0��ʼ�ģ�i����Ҫ-1
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
}



