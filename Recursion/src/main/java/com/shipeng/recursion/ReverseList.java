package com.shipeng.recursion;

class Node {

	public int value = 0;
	public Node next = null;

	public Node(int value) {
		this.value = value;
	}
}

public class ReverseList {

	public static void main(String[] args) {

		Node list1 = generateList();
		printList(list1);
		System.out.println("=============");
		
		//reverse the list with iterative method
		Node newHead = reverseListIterative(list1);
		
		//print the list
		printList(newHead);
		System.out.println("=============");
		
		//reverse the list with recursive method
		Node newHeadRecursive = reverseListRecursive(newHead);
		printList(newHeadRecursive);
		
	} // end main
	
	
	private static Node reverseListRecursive(Node head) {
		//base case: head == null || head.next == null
		if (head == null || head.next == null) {
			return head;
		}
		
		
		Node next = head.next;
		Node newHead = reverseListRecursive(next);
		head.next = null;
		next.next = head;
		
		return newHead;
	}
	
	private static Node reverseListIterative(Node head) {
		Node cur = head;
		Node prev = null;
		while (cur != null) {
			Node next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		return prev;
	}
	

	private static Node generateList() {

		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = null;

		return n1;
	}
	
	private static void printList(Node head) {
		Node cur = head;
		while (cur != null) {
			System.out.println(cur.value);
			cur = cur.next;
		}
	}

} // end ReverseList
