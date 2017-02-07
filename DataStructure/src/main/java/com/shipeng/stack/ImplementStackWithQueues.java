package com.shipeng.stack;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackWithQueues {
	
	private Queue<Integer> q1 = null;
	private Queue<Integer> q2 = null;
	private int top;
	
	public ImplementStackWithQueues() {
		q1 = new LinkedList<Integer>();
		q2 = new LinkedList<Integer>();
	}
	
	public void push(int x) {
		q1.add(x);
		top = x;
	}
	
	public int pop() {
		while (q1.size() > 1) {
			top = q1.remove();
			q2.add(top);
		}
		int result = q1.remove();
		Queue<Integer> temp = q1;
		q1 = q2;
		q2 = temp;
		return result;
	}
	
	public int top() {
		return top;
	}
	
	public boolean empty() {
		return (q1.size() + q2.size()) == 0;
	}
	
}


