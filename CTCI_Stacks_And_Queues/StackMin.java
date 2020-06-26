package CTCI_Stacks_And_Queues;

import java.util.ArrayList;

public class StackMin {
    Node head;
    ArrayList<Integer> mins;

    public static void main(String[] args) {
        StackMin stack = new StackMin();
        stack.push(3);
        System.out.println(stack.min());
        stack.push(2);
        System.out.println(stack.min());
        stack.push(6);
        System.out.println(stack.min());
        stack.push(1);
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
        stack.pop();
    }

    public StackMin(){
        head = new Node();
        mins = new ArrayList<>();
    }

    public void push(int value){
        if(mins.size() > 1){
            mins.add(value < mins.get(mins.size()-1) ? value : mins.get(mins.size()-1));
        }
        else{
            mins.add(value);
        }
        Node next = new Node(value);
        next.next = head;
        head = next;
        print();
    }

    public int pop(){
        mins.remove(mins.get(mins.size()-1));
        if(head == null) return -1;
        int value = head.value;
        head = head.next;
        print();
        return value;
    }

    public int min(){
        return mins.get(mins.size()-1);
    }

    public void print(){
        Node temp = head;
        System.out.print("HEAD");
        while(temp != null){
            if(temp.value != -1) System.out.print(" <- " + temp.value);
            temp = temp.next;
        }
        System.out.println();
    }
}
