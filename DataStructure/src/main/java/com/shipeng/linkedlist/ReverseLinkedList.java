package com.shipeng.linkedlist;

class Node {
	Node next = null;
	int value = 0;
	public Node(int value) {
		this.value = value;
	}
}

public class ReverseLinkedList {

	private static Node generateList() {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = null;
		
		return node1;
	} //end generateList method
	
	private static void printList(Node head) {
		Node curr = head;
		while (curr != null) {
			System.out.println(curr.value);
			curr = curr.next;
		}
		System.out.println("=====================");
	}
	
	private static Node reverseListRecursion(Node head) {
		// base case
		if (head == null || head.next == null) {
			return head;
		}
		
		// recursion
		Node newHead = reverseListRecursion(head.next);
		head.next.next = head;
		head.next = null;
		
		return newHead;
	}
	
	private static Node reverseListIterative(Node head) {
		if (head == null) {
			return head;
		}
		
		Node curr = head;
		Node prev = null;
		while (curr != null) {
			Node next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}
	
	
	public static void main(String[] args) {
		
		Node list1 = generateList();
		printList(list1);
		
		// reverse the linked list with recursion
		Node newHead = reverseListRecursion(list1);
		printList(newHead);
		
		// reverse the linked list with iteration
		Node newHead1 = reverseListIterative(newHead);
		printList(newHead1);
		
	} // end main
	
}
