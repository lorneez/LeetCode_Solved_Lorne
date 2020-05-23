import java.util.Arrays;

/**
 * Runtime complexity: O(log(n))
 * Space complexity: O(1)
 * MarkAndToys finds the max number of toys Mark can buy given k dollars. The first step is to sort the array from lowest
 * to highest price. The Arrays.sort() method is O(log(n)) because that is the fastest it can take to sort.
 */
public class MarkAndToys {
    static int maximumToys(int[] prices, int k) {
        Arrays.sort(prices);
        int total = 0;
        for(int i=0; i<prices.length; i++){
            total += prices[i];
            if(total>k){
                return i;
            }
        }
        return -1;
    }
}
