// Implement Queue using Stacks

import java.util.Stack;

class MyQueue {

    private Stack<Integer> stack;
    private Stack<Integer> subStack;

    public MyQueue() {
        stack = new Stack<>();
        subStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
    }

    public int pop() {
        while (!stack.isEmpty()) {
            subStack.push(stack.pop());
        }
        int val = subStack.pop();
        while(!subStack.isEmpty()) {
            stack.push(subStack.pop());
        }
        return val;
    }

    public int peek() {
        while (!stack.isEmpty()) {
            subStack.push(stack.pop());
        }
        int val = subStack.peek();
        while(!subStack.isEmpty()) {
            stack.push(subStack.pop());
        }
        return val;
    }

    public boolean empty() {
        return stack.isEmpty();
    }
}
