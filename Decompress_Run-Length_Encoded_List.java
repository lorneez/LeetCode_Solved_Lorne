import java.util.Arrays;

class Solution {
    public int[] decompressRLElist(int[] nums) {
        int length=0;
        for(int x=0; x<nums.length; x=x+2){
            length=length+nums[x];
        }
        int[] ret=new int[length];
        int total=0;
        for(int i=0; i<nums.length; i=i+2){
            int target = nums[i+1];
            int times = nums[i];
            for(int j=0; j<times; j++){
                ret[total] = target;
                total = total + 1;
            }
        }
        return ret;
    }
}
