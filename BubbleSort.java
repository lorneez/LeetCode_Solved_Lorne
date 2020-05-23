/**
 * Runtime complexity: O(n)
 * Space complexity: O(1)
 * BubbleSort sorts the array with a nested for loop. It counts the number of swaps and then prints it out
 * along with the first and last element.
 */
public class BubbleSort {
    static void countSwaps(int[] a) {
        int count = 0;
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                // Swap adjacent elements if they are in decreasing order
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    count ++;
                }
            }
        }
        System.out.println("Array is sorted in " + count + " swaps.");
        System.out.println("First Element: " + a[0]);
        System.out.println("Last Element: " + a[n-1]);
    }
}
