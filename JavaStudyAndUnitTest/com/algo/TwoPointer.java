package com.algo;

public class TwoPointer {
	public static void main(String[] args) {
		TwoPointer algo = new TwoPointer();
		algo.testFunction();
	}

	class Node{
		int value;
		Node next;
		
		public Node(int value, Node next){
			this.value = value;
			next = null;
		}
	}

	public void testFunction(){
		Node head = new Node(1, null);
		isCircleList(head);
		
		Node second = new Node(2, null);
		head.next = second;
		isCircleList(head);
		
		Node third = new Node(3, null);
		second.next = third;
		isCircleList(head);
		
		third.next = head;
		isCircleList(head);
	}


	public Boolean isCircleList(Node arrList){
		if (arrList == null){
			return false;
		}
		Node first = arrList;
		Node second = first;
		while (first != null){
			System.out.println("Node value: " + first.value);
			first = first.next;
			if (first == null){
				System.out.println("no");
				return false;
			}
			first = first.next;
			if (first == null){
				System.out.println("No");
				return false;
			}
			second = second.next;
			if (first == second){
				System.out.println("yes: " + first.value);
				return true;
			}
		}
		return false;
	}
}
