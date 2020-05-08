import java.util.HashMap;
import java.util.Map;

/**
 * Runtime complexity: O(n)
 * Space complexity: O(n)
 * TwoSum is solved by utilizing a map that holds the value of the number and index. Once the diff matches the number
 * we know that we have found the match.
 * If we wanted space complexity of O(1), we can use the brute force approach with a nested for loop.
 */
class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int [] ret = new int[2];
        Map<Integer, Integer> myMap = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int diff = target-nums[i];
            if(myMap.containsKey(diff)){
                int ind = myMap.get(diff);
                ret[0] = ind;
                ret[1] = i;
                break;
            }
            else{
                myMap.put(nums[i], i);
            }
        }
        return ret;
    }
}