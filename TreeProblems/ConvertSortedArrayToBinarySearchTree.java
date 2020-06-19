package TreeProblems;

class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return form(nums, 0, nums.length);
    }

    public TreeNode form(int[] nums, int start, int end){
        if(end == start) return null;
        int mid = (end + start)/2;
        TreeNode r = new TreeNode(nums[mid]);
        r.left = form(nums, start, mid);
        r.right = form(nums, mid+1, end);
        return r;
    }
}