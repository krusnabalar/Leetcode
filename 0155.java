import java.util.*;

class MinStack {
    LinkedList<Integer> stack = new LinkedList<Integer>();
    List<Integer> minSoFar = new ArrayList<>();
    int stackSize = 0;

    public MinStack() {
    }

    public void push(int val) {
        stack.add(val);
        if (stackSize++ == 0) {
            minSoFar.add(val);
        } else {
            minSoFar.add(val < minSoFar.get(stackSize - 2) ? val : minSoFar.get(stackSize - 2));
        }
    }

    public void pop() {
        minSoFar.remove(minSoFar.get(stackSize-- - 1));
        stack.removeLast();
    }

    public int top() {
        return stack.getLast();
    }

    public int getMin() {
        return minSoFar.get(this.stackSize - 1);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */