import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Runtime complexity: O(n^2)
 * Space complexity: O(1)
 * ThreeSum finds the unique sets of integers that add up to 0 within an array of integers. It does this
 * by performing twoSum on each of the numbers in the array. In doing so, it finds the unique values
 * and also skips over duplicate values. The time xomplexi
 */
class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new LinkedList();
        for(int i=0; i<nums.length-2; i++){
            // this checks for duplicate
            if(i==0 || (i>0 && nums[i] != nums[i-1])){
                // two sum
                int left = i+1;
                int right = nums.length-1;
                int target = 0-nums[i];
                while(right>left){
                    if(nums[left] + nums[right] == target){
                        ret.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        // checks for duplicates right next to the found pair
                        while(right>left && nums[right] == nums[right-1]) right--;
                        while(right>left && nums[left] == nums[left+1]) left++;
                        right --;
                        left ++;
                    }
                    else if(nums[left] + nums[right] > target){
                        right --;
                    }
                    else{
                        left ++;
                    }
                }
            }
        }
        return ret;
    }
}
