import java.util.HashMap;
import java.util.Map;

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