package aa;


import java.util.Stack;

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

    Stack in;
    Stack out;

    /** Initialize your data structure here */
    public ImplementQueueWithTwoStacks() {
        in = new Stack();
        out = new Stack();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        // aways push into the in stack
        in.push(x);
    }

    /** Removes the element from in from of the queue and returns the element */
    public int pop() {
        move();
        return (int) out.pop();
    }

    public void move() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
    }

    /** Get the front element . */
    public int peek() {
        move();
        return (int)out.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }

}