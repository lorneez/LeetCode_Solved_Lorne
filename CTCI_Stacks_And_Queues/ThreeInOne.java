package CTCI_Stacks_And_Queues;

public class ThreeInOne {
    /*
    This problem is interesting. The current implementation uses space twice as fast and is not reusable in terms
    of when you add n/2 elements, you are done.

    A lesser efficient but space saving solution is having each stack next to each other and shifting when
    adding to stacks 1 and 2.

    An efficient solution is just to implement and give 1/3 space to each array.
     */
    private int[] arr;
    private int[] pointers;
    private int head;

    public static void main(String[] args){
        ThreeInOne stack = new ThreeInOne(200, 3);
        ThreeInOne test = new ThreeInOne(200, 3);
        // test 1
//        stack.push(1,1);
//        stack.push(1,1);
//        stack.push(1,1);
//        stack.push(2,2);
//        stack.push(2,2);
//        stack.push(1,1);
//        stack.push(1,1);
//        stack.pop(2);
//        stack.push(2,2);
//        stack.pop(2);
//        stack.pop(2);

        // test 2
//        test.push(1,1);
//        test.push(1,1);
//        test.push(1,1);
//        test.push(1,1);
//        test.push(1,1);
//        test.push(1,1);
//        stack.push(1,1);
//        stack.push(1,1);
//        stack.pop(1);
//        stack.push(1,1);
//        stack.pop(1);
//        stack.push(1,1);
//        stack.push(1,1);
//        stack.push(1,1);
//        stack.push(1,1);
//        stack.push(1,1);

        // test 3
        stack.push(1,1);
        stack.push(1,1);
        stack.pop(1);
        stack.pop(1);
        stack.pop(1);

        stack.push(1,1);
        stack.push(1,1);
        stack.push(1,1);
    }

    public ThreeInOne(int size, int numStacks){
        arr = new int[size];
        pointers = new int[numStacks];
        for(int i=0; i<numStacks; i++){
            pointers[i] = -1;
        }
        head = 0;
    }

    public void push(int stack, int value){
        arr[head++] = value;
        arr[head++] = pointers[stack-1];
        pointers[stack-1] = head - 2;
        print();
    }

    public int pop(int stack){
        if(pointers[stack-1] != -1){
            int value = arr[pointers[stack-1]];
            int p = arr[pointers[stack-1] + 1];
            arr[pointers[stack-1]] = 0;
            arr[pointers[stack-1] + 1] = 0;
            pointers[stack-1] = p;
            print();
            return value;
        }
        return -1;
    }

    public void print(){
        for(int i=0; i<head; i+=2){
            System.out.print("[" + arr[i] + " : " + arr[i+1] + "]");
        }
        System.out.println();
    }
}
