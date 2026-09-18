// Maximum Frequency Stack

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class FreqStack {

    private Map<Integer, Integer> count;
    private Map<Integer, Stack<Integer>> stacks;

    private int maxCount = 0;

    public FreqStack() {
        this.count = new HashMap<>();
        this.stacks = new HashMap<>();
    }

    public void push(int val) {
        int valCount = count.getOrDefault(val, 0) + 1;
        count.put(val, valCount);
        if (stacks.containsKey(valCount)) {
            stacks.get(valCount).push(val);
        } else {
            var stk = new Stack<Integer>();
            stk.push(val);
            stacks.put(valCount, stk);
        }
        maxCount = Math.max(maxCount, valCount);
    }

    public int pop() {
        int poppedElement = stacks.get(maxCount).pop();
        int prevCount = count.get(poppedElement);
        if (prevCount == 1) count.remove(poppedElement);
        else count.put(poppedElement, prevCount - 1);
        if (stacks.get(maxCount).isEmpty()) {
            stacks.remove(maxCount);
            maxCount--;
        }
        return poppedElement;
    }
}