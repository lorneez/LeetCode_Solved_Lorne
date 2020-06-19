package Implementations.Heap;

public class HeapSort {
    private final static int size = 67;
    public static void main(String[] args){
        int[] unsorted = new int[size];
        for(int i=0; i<size; i++){
            //int random = ((i*3) + 1)%size;
            int random = i;
            unsorted[i] = random + 1;
        }
        minHeapSort(unsorted);
        for(int i=0; i<size; i++){
            System.out.println(unsorted[i]);
        }
    }
    public static void maxHeapSort(int[] unsorted){
        MaxHeapCustom maxHeap = new MaxHeapCustom(size);
        for(int i : unsorted){
            maxHeap.insert(i);
        }
        for(int i=0; i<size; i++){
            //System.out.println("-------");
            unsorted[i] = maxHeap.extractMax();
            //maxHeap.print();

        }
    }
    public static void minHeapSort(int[] unsorted) {
        MinHeapCustom minHeap = new MinHeapCustom(size);
        for (int i : unsorted) {
            minHeap.insert(i);
        }
        for (int i = 0; i < size; i++) {
            //System.out.println("-------");
            unsorted[i] = minHeap.extractMin();
            //maxHeap.print();

        }
    }
}
