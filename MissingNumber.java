/**
 * Runtime complexity: O(n)
 * Space complexity: O(1)
 * MissingNumber finds the missing number in a array of integers 0-n. It does this by computing the sum of the array
 * and subtracting it from the sum of the first n positive integers.
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int sum = (nums.length+1)*nums.length/2;
        int sumArr = 0;
        for(int x:nums){
            sumArr += x;
        }
        return sum - sumArr;
    }
}
