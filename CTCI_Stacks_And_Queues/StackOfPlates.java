package CTCI_Stacks_And_Queues;

import java.util.ArrayList;
import java.util.Stack;

public class StackOfPlates {
    private int stackSize;
    private ArrayList<Stack<Integer>> stacks;

    public static void main(String[] args){
        StackOfPlates test = new StackOfPlates(3);
        test.push(1);
        test.push(2);
        test.push(3);
        test.push(4);
        test.push(5);
        test.push(6);
        test.push(7);
        test.push(8);
        test.print();
    }

    public StackOfPlates(int size){
        stackSize = size;
        stacks = new ArrayList<>();
        stacks.add(new Stack<Integer>());
    }

    public void push(int val){
        int size = stacks.get(stacks.size() - 1).size();
        if(size == stackSize) {
            //System.out.println("new stack with " + val);
            Stack<Integer> nextStack = new Stack<>();
            nextStack.push(val);
            stacks.add(nextStack);
            //System.out.println(" stack size " + stacks.size());
        }
        else {
            stacks.get(stacks.size() - 1).push(val);
        }
    }

    public int pop(){
        int val = stacks.get(stacks.size() - 1).pop();
        if(stacks.get(stacks.size() - 1).size() == 0) stacks.remove(stacks.size() - 1);
        return val;
    }

    public void print(){
        for(int i=stacks.size()-1; i>=0; i--){
            //System.out.println(stacks.get(i).size());
            int size = stacks.get(i).size();
            for(int j=0; j<size; j++){
                System.out.print(stacks.get(i).pop());
            }
        }
    }
}
