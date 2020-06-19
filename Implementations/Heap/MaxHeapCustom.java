package Implementations.Heap;

public class MaxHeapCustom {
    private int[] heap;
    private int size;
    private int maxSize;

    public static void main(String[] args){
        MaxHeapCustom test = new MaxHeapCustom(20);
        test.insert(10);
        test.print();
        test.insert(1);
        test.print();
        test.insert(4);
        test.print();
        test.insert(2);
        test.print();
        test.insert(9);
        test.print();
        test.insert(6);
        test.print();
        test.insert(8);
        test.print();
        test.insert(3);
        test.print();
        test.insert(7);
        test.print();
        test.insert(5);
        test.print();
        System.out.println(test.getMax());
    }

    public MaxHeapCustom(int maxSize){
        this.heap = new int[maxSize + 1]; // the +1 is included because maxSize represents the maximum index
        this.size = 0;
        this.maxSize = maxSize;
        heap[0] = Integer.MAX_VALUE;
    }

    /**
     * inserts an element at the end and then moves up the tree to fix problems. indexing is started at 1 so the
     * value of next element is ++size
     * @param value
     */
    public void insert(int value){
        heap[++size] = value;
        int current = size;
        while(heap[current] > heap[parent(current)]){
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public void print(){
        for(int i=1; i<size/2; i++){
            System.out.println("Parent: " + heap[i] + " Left: " + heap[2 * i] + " Right: " + heap[2 * i + 1]);
        }
        for(int i=1; i<size+1; i++){
            System.out.print(heap[i]);
        }
        System.out.println("");

    }

    public int extractMax(){
        int max = heap[1];
        //System.out.println(size + " " + heap[size]);
        heap[1] = heap[size--];

        if(size > 0){
            maxHeapify(1);
        }
        //System.out.println("after swap nax: " + heap[1]);
        return max;
    }

    public int getMax(){
        return heap[1];
    }

    private int parent(int index){
        return index / 2;
    }

    private int rightChild(int index){
        return index * 2 + 1;
    }

    private int leftChild(int index){
        return index * 2;
    }

    /**
     * this method checks if the leaf index is valid. it does this by checking if the index is less than size and also
     * greater than half of size. because the heap represents a complete binary tree. one property of the complete
     * binary tree is that the number of leaf nodes is always equal to either n total nodes / 2 or n total nodes / 2 + 1.
     * @param index
     * @return
     */
    private boolean isLeaf(int index){
        if(size <= 3 && size >1){
            if(index == 3 || index == 2){
                return true;
            }
            else{
                return false;
            }
        }
        if(index <= size && index >= (size) / 2){
            return true;
        }
        return false;
    }

    private void swap(int first, int second){
        int temp = heap[first];
        heap[first] = heap[second];
        heap[second] = temp;
    }

    /**
     * this method fixes a heap by moving an element down the tree into the correct position.
     * @param index
     */
    private void maxHeapify(int index) {
        if (isLeaf(index)) {
            //System.out.println("leaf " + index + " " + heap[index] + " " + size);
            return;
        } else {
            if (heap[index] < heap[rightChild(index)] || heap[index] < heap[leftChild(index)]) {
                if (heap[leftChild(index)] < heap[rightChild(index)]) {
                    swap(index, rightChild(index));
                    maxHeapify(rightChild(index));
                } else {
                    swap(index, leftChild(index));
                    maxHeapify(leftChild(index));
                }
            }
        }
    }
}
