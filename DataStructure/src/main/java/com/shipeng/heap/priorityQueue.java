package com.shipeng.heap;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * A min-heap is a binary tree such that the data contained in each node is less than (or equal to)
 * the data in that node's children.
 * 
 * The binary tree is complete. 
 * A max-heap is a binary tree such that the data contained in each node is greater than (or equal to)
 * the data in that node's children.
 * 
 * By default, PriorityQueue is a minHeap.
 * 
 */


public class priorityQueue {

	public static void main(String[] args) {
		
		Queue<Integer> heap = new PriorityQueue<Integer>();
		
		for (int i = 0; i < 10; i++) {
			heap.add(i);
		}
		
		System.out.println("the peek of heap is: " + heap.peek());
		
		printHeap(heap);
	}
	
	private static void printHeap(Queue<Integer> heap) {
		Iterator<Integer> itr = heap.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
	
}
