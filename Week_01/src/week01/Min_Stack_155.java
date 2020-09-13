package week01;

import java.util.ArrayDeque;
import java.util.Deque;

public class Min_Stack_155 {
    int min = Integer.MAX_VALUE;
    private Deque<Integer> stack;
    /** initialize your data structure here. */
    public void MinStack() {
        stack = new ArrayDeque<>();
    }

    public void push(int x) {
        if (x <= min) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        if (stack.pop () == min) {
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
