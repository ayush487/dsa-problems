// Implement Stack using Queues

import java.util.LinkedList;
import java.util.Queue;

class MyStack {

    private Queue<Integer> queue;
    private Queue<Integer> subQueue;

    public MyStack() {
        queue = new LinkedList<>();
        subQueue = new LinkedList<>();
    }

    public void push(int x) {
        subQueue.offer(x);
        while(!queue.isEmpty()) {
            subQueue.offer(queue.poll());
        }
        var temp = queue;
        queue = subQueue;
        subQueue = temp;
    }

    public int pop() {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}