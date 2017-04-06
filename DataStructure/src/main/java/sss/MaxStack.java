package sss;

import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;

/*
 * MaxStack
 * The MaxStack is a stack data structure that also allows stacklike access to the elements by their 
 * value. Push, peek, pop, peekMax and popMax.
 * 
 * 3, 1, 5, 2
 * 
 * Comments:
 *     Clarify, make sure you understand the problem.
 *         Goal, assumption/access pattern, example
 *     Workable soution/optimize
 *     Hybrid data structure more than one internal data structure.
 *         Challenge is to keep them in sync with minimal code.
 *     
 *     Ask/clarify for expectation.
 *     Ask for examples.
 *     for example, given a stack of {1,3,2,5,3,4,5,2}
 *     peek() -> 2, peekMax() -> 5
 *     pop() -> 2; peek() -> 5, peekMax() -> 5
 *     pop() -> 5; peek() -> 4, peekMax() -> 5
 *     push(6); peek() -> 6, peekMax() -> 6
 *     popMax() -> 6; peek -> 4, peekMax() -> 5
 *     popMax() -> 5; peek -> 4, peekMax() -> 4
 *     
 *     Solutions:
 *         Stack only:
 *             push, pop, peek, O(1), peekMax, popMax O(n)
 *         Max Heap by values
 *             Push popMax logn, peekMax O(1); pop, peek O(N)
 *         Heap + DLL
 *             Heap stores DLL node. Your DS has reference to top of list (dummy node is the coding trick).
 *             You need to customize heap for optimal complexity. 
 *             Doable but not supported by standard libraries. 
 *         Balanced BST + DLL
 *         Most importantly, know all the tradeoffs
 *     
 *     Other similar problems:
 *         Min Stack (peek min only, no popMin) => Two stacks
 *         First non-repeated object in stream ==> map + doubly linked list
 *         Retain best cache/LRU ==> Map + sorted data structure (e.g. DLL, treeset/heap)
 *         RandomRemove ==> Map + array   
 * 
 */


public class MaxStack {

	/**
	 * Solution 1: Doubly linked list + MaxHeap
	 */
	private class MaxStack1 {
		class Node {
			int value;
			Node prev;
			Node next;
			Node(int val) {
				this.value = val;
				this.prev = null;
				this.next = null;
			}
		}
		// doublyLinkedList dummyHead and tail pointer
		private Node dummyHead = null;
		private Node tail = null;
		
		// save the current max value in heap
		private PriorityQueue<Node> maxHeap;
		public MaxStack1() {
			dummyHead = new Node(Integer.MIN_VALUE);
			tail = dummyHead;
			maxHeap = new PriorityQueue<Node>(new Comparator<Node>() {
				@Override
				public int compare(Node o1, Node o2) {
					if (o1.value == o2.value) return 0;
					return o1.value < o2.value ? 1: -1;
				}
			});
		}
		
		//O(logN)
		public void push(int value) {
			//add the element to doublyLinkedList
			Node newNode = new Node(value);
			tail.next = newNode;
			tail.next.prev = tail;
			tail = tail.next;
			
			//update maxHeap
			maxHeap.add(newNode);
		}
		
		//O(1)
		public int peek() {
			if (tail == dummyHead) {
				// or return null
				throw new NoSuchElementException("No element in max stack");
			}
			return tail.value;
		}
		
		//O(N)
		public int pop() {
			if (tail == dummyHead) {
				throw new NoSuchElementException("No element in max stack");
			}
			Node temp = tail;
			int res = temp.value;
			// update tail pointer
			tail = tail.prev;
			tail.next.prev = null;
			tail.next = null;
			
			// cannot use lazy deletion here
			maxHeap.remove(temp); //O(n + log(n))
			return res;
		}
		
		//O(1)
		public int peekMax() {
			if (maxHeap.isEmpty()) {
				throw new NoSuchElementException("No element in max stack.");
			}
			return maxHeap.peek().value;
		}
		
		//O(logN)
		public int popMax() {
			if (maxHeap.isEmpty()) {
				throw new NoSuchElementException("No element is in max stack");
			}
			// delete node from maxHeap
			Node tempNode = maxHeap.poll();
			// delete node from doublyLinkedList
			tempNode.prev.next = tempNode.next;
			if (tempNode.next != null) {
				tempNode.next.prev = tempNode.prev;
			}
			// update tail pointer
			if (tail == tempNode) {
				tail = tempNode.prev;
			}
			return tempNode.value;
		}
		
	}
}
