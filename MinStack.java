import java.util.ArrayList;

/**
 * Runtime complexity: O(1)
 * Space complexity: O(n)
 * MinStack is a stack that runs push, pop, top, and getMin in constant time.
 */
public class MinStack {
    private ArrayList<Integer> stack;
    private ArrayList<Integer> minValues;
    private int size;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new ArrayList<>();
        minValues = new ArrayList<>();
        size = 0;
    }

    public void push(int x) {
        stack.add(x);
        if(minValues.size() !=0){
            minValues.add(Math.min(minValues.get(size-1),x));
        }
        else{
            minValues.add(x);
        }
        size ++;
    }

    public void pop() {
        stack.remove(size-1);
        minValues.remove(size-1);
        size --;
    }

    public int top() {
        return stack.get(size-1);
    }

    public int getMin() {
        return minValues.get(size-1);
    }
}
