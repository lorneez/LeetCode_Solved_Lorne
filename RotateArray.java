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

    /**
     * Runtime complexity: O(n)
     * Space complexity: O(1)
     * This version of rotate array is O(n) because it uses the mod jumping method. It cycles into each equivalence
     * class that exists in nums.length mod k and swaps the elements in them.
     */
    public void rotateFastest(int[] nums, int k) {
        int len = nums.length;
        k = k%len;
        int gcd = 0;
        for(int i=1; i<=len && i<=k; i++){
            if(k%i == 0 && len%i == 0){
                gcd = i;
            }
        }
        for(int x=0; x<gcd; x++){
            nums = rot(nums, x, k);
        }
    }
    private int[] rot(int[] arr, int x, int k){
        int len = arr.length;
        int startpos = x;
        int nextpos = (x+k)%len;
        int nextint = arr[x];
        int last = arr[nextpos];
        while(startpos != nextpos){
            arr[nextpos] = nextint;
            nextint = last;
            nextpos = (nextpos+k)%len;
            if(startpos != nextpos){
                last = arr[nextpos];
            }
        }
        arr[startpos] = last;
        return arr;
    }
}
