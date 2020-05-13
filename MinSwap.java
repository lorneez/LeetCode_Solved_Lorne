public class MinSwap {
    /**
     * Runtime complexity: O(n^2)
     * Space complexity: O(1)
     * minimumSwaps uses two for loops to sort the array in an inefficient method.
     */
    static int minimumSwaps(int[] arr) {
        int count = 0;
        boolean found = false;
        for(int i=0; i<arr.length;i++){
            if(arr[i] == i+1){
                continue;
            }
            for(int j=i; j<arr.length; j++){
                if(arr[j] == i+1){
                    count ++;
                    arr[j] = arr[i];
                    arr[i] = i+1;
                    found = true;
                    break;
                }
            }
            if(found){
                found = false;
            }
            else{
                return count;
            }

        }
        return count;
    }

    /**
     * Runtime complexity: O(n)
     * Space complexity: O(n)
     * minimumSwapsEfficient uses a position array to store the positions of the elements in the array. Then it for
     * loops and swaps when it finds incorrect elements. It puts the correct value in the array and swaps the incorrect
     * with the correct value's position. Then it updates the incorrect value's position array so it can still be found.
     */
    static int minimumSwapsEfficient(int[] arr) {
        int[] position = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            position[arr[i] - 1] = i;
        }
        int swaps = 0;
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] != j + 1) {
                swaps++;
                int temp = arr[j]; // value out of position
                arr[position[j]] = temp; // put the incorrect value at the location of the correct value j+1
                arr[j] = j + 1; // correct value put in
                // switch in the position arrays
                position[temp - 1] = position[j];
            }
        }
        return swaps;
    }
}
