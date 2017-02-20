package aa;

import java.util.LinkedList;

/*
 * Implement queue using stacks
 * 
 * Implement the following operations of a queue using stacks.
 * 
 * push(x) -- Push element x to the back of queue.
 * pop() -- Removes the element from in front of queue.
 * peek() -- Get the front element.
 * empty() -- Return whether the queue is empty.
 * 
 * Notes:
 * You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
 * Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
 * You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).
 * 
 * 
 */

public class ImplementQueueWithTwoStacks {

}

class MyQueue {

	private LinkedList<Integer> in;
	private LinkedList<Integer> out;

	/** Initialize your data structure here. */
	public MyQueue() {
		in = new LinkedList<Integer>();
		out = new LinkedList<Integer>();
	}

	/** Push element x to the back of queue. */
	public void push(int x) {
		// always push into the stack.
		in.offerFirst(x);
	}

	/** Removes the element from in front of queue and returns that element. */
	public int pop() {
		// if out stack is empty,
		// need to move the elements from in stack to out stack.
		move();
		return out.pollFirst();
	}

	/** Get the front element. */
	public int peek() {
		move();
		return out.peekFirst();
	}

	// when out stack is empty, move the elements from in stack to out stack.
	private void move() {
		if (out.isEmpty()) {
			while (!in.isEmpty()) {
				out.offerFirst(in.pollFirst());
			}
		}
	}

	/** Returns whether the queue is empty. */
	public boolean empty() {
		return in.size() == 0 && out.size() == 0;
	}
}

/**
 * Your MyQueue object will be instantiated and called as such: MyQueue obj =
 * new MyQueue(); obj.push(x); int param_2 = obj.pop(); int param_3 =
 * obj.peek(); boolean param_4 = obj.empty();
 */