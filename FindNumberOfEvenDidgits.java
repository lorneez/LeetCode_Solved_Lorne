import java.lang.Math;
class Solution {
    public int findNumbers(int[] nums) {
        int total = 0;
        for(int i=0; i<nums.length; i++){
            int check = (int)Math.log10(nums[i]);
            if(check%2==1){
                total++;
            }
        }
        return total;
    }
}
