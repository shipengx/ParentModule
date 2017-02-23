package aa;

import java.util.Stack;

public class MyQueue {

	Stack<Integer> in;
	Stack<Integer> out;

	/** Initialize your data structure here. */
	public MyQueue() {
		in = new Stack<Integer>();
		out = new Stack<Integer>();
	}

	/** Push element x to the back of queue. */
	public void push(int x) {
		in.push(x);
	}

	/** Removes the element from in front of queue and returns that element. */
	public int pop() {
		if (out.isEmpty()) {
			while (!in.isEmpty()) {
				out.push(in.pop());
			}
		}
		int result = out.pop();
		return result;
	}

	/** Get the front element. */
	public int peek() {
		if (out.isEmpty()) {
			while (!in.isEmpty()) {
				out.push(in.pop());
			}
		}
		return out.peek();
	}

	/** Returns whether the queue is empty. */
	public boolean empty() {
		return in.isEmpty() && out.isEmpty();
	}
}
