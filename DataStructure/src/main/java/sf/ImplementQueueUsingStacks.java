package sf;

import java.util.Stack;

/**
 * Implement queue using stacks
 *
 * push(x) -- push element x to the back of queue
 * pop() -- removes the element from in front of the queue
 * peek() -- get the front element
 * empty() -- return whether the queue is empty
 *
 * Example:
 * MyQueue queue = new MyQueue();
 * queue.push(1);
 * queue.push(2);
 * queue.peek();   // returns 1
 * queue.pop();    // returns 1
 * queue.empty();  // return false
 *
 */

public class ImplementQueueUsingStacks {

    Stack<Integer> in;
    Stack<Integer> out;

    /** Initialize your data structure here. */
    public ImplementQueueUsingStacks() {
        in = new Stack<>();
        out = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        in.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        move();
        return out.pop();
    }

    /** Get the front element. */
    public int peek() {
        move();
        return out.peek();
    }

    private void move() {
        if (out.isEmpty()) {
            // only out push when out stack is empty.
            // so that the old records are still in correct order in out stack.
            // this is the key
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return in.size() == 0 && out.size() == 0;
    }

}
