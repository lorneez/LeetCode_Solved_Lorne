public class RotateArray {
    /**
     * Runtime complexity: O(n*k)
     * Space complexity: O(1)
     * RotateArray rotates the array once k times.
     */
    public void rotate(int[] nums, int k) {
        for(int i=0; i<k; i++){
            int last = nums[nums.length-1];
            for(int j=nums.length-1; j>0; j--){
                nums[j] = nums[j-1];
            }
            nums[0] = last;
        }
    }

    /**
     * Runtime complexity: O(n)
     * Space complexity: O(n)
     * Rotate left array creates a new array to rotate the array d spaces left.
     */
    static int[] rotLeft(int[] a, int d) {
        int[] ret = new int[a.length];
        for(int i=0; i<a.length; i++){
            ret[i] = a[(i+d)%a.length];
        }
        return ret;
    }
}
