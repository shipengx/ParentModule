package aa;

import java.util.Deque;
import java.util.LinkedList;

/*
 * Min stack
 * 
 * Design a stack that supports push, pop, top and retrieving the minimum element in constant time.
 * 
 * push(x) --- push element x onto stack.
 * pop() --- removes the element on top of the stack.
 * top() --- get the top elemnt.
 * getMin() --- retrieve the minimum element in the stack.
 * 
 * Example:
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin(); ----> return -3.
 * minStack.pop();
 * minStack.top();    ---> returns 0.
 * minStack.getMin(); ---> returns -2.
 * 
 */

public class MinStack {
	private Deque<Integer> stack;
	private Deque<Integer> minStack;

	/** initialize your data structure here. */
	public MinStack() {
		stack = new LinkedList<Integer>();
		minStack = new LinkedList<Integer>();
	}

	public void push(int x) {
		stack.offerFirst(x);
		// when value <= current min value in stack.
		// need to push the value onto minStack.
		if (minStack.isEmpty() || x <= minStack.peekFirst()) {
			minStack.offerFirst(x);
		}
	}

	public void pop() {
		if (stack.isEmpty()) {
			return;
		}
		Integer result = stack.pollFirst();
		// when the popped value is the same as top value of minStack, the value
		// need to be popped from minStack as well.
		if (minStack.peekFirst().equals(result)) {
			minStack.pollFirst();
		}
	}

	public int top() {
		if (stack.isEmpty()) {
			return -1;
		}
		return stack.peekFirst();
	}

	public int getMin() {
		if (minStack.isEmpty()) {
			return -1;
		}
		return minStack.peekFirst();
	}
}
