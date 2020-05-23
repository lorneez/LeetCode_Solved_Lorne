public class MergeSortInversionCount {
    // Complete the countInversions function below.
    public static void main(String[] args){
        int[] arr = new int[4];
        arr[0]=1;
        arr[1]=3;
        arr[2]=5;
        arr[3]=7;
        System.out.println(countInversions(arr));
    }
    static long countInversions(int[] arr) {
        return mergeSort(arr, 0, arr.length - 1);
    }

    static long mergeSort(int[] arr, int left, int right) {
        if (right > left) {
            int middle = (right + left) / 2;
            long x = mergeSort(arr, left, middle);
            long y = mergeSort(arr, middle + 1, right);
            for(int i=0; i<4; i++){
                System.out.print(arr[i]);
            }
            System.out.println("");;
            System.out.println(left + " " + middle + " " + right);
            long z = merge(arr, left, middle, right);
            for(int i=0; i<4; i++){
                System.out.print(arr[i]);
            }
            System.out.println("");;
            return x + y + z;
        } else {
            return 0;
        }
    }

    static long merge(int[] arr, int left, int middle, int right) {

        long count = 0;
        int leftArrSize = middle - left + 1;
        int rightArrSize = right - middle;
        int[] leftArrTemp = new int[leftArrSize];
        int[] rightArrTemp = new int[rightArrSize];
        for (int x = 0; x < leftArrSize; x++) {
            leftArrTemp[x] = arr[x + left];
        }
        for (int y = 0; y < rightArrSize; y++) {
            rightArrTemp[y] = arr[y + middle + 1];
        }
        int initL = 0, initR = 0;
        int mergeCount = left;
        // copy until one is done
        while (leftArrSize > initL && rightArrSize > initR) {
            if (leftArrTemp[initL] <= rightArrTemp[initR]) {
                arr[mergeCount++] = leftArrTemp[initL++];
            } else {
                arr[mergeCount++] = rightArrTemp[initR++];
                count += (leftArrSize - initL);
            }
        }

        // copy rest of left
        while (initL < leftArrSize) {
            arr[mergeCount++] = leftArrTemp[initL++];
        }
        // copy rest of right
        while (initR < rightArrSize) {
            arr[mergeCount++] = rightArrTemp[initR++];
        }
        System.out.println(mergeCount);
        return count;
    }
}
