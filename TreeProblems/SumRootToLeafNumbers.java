package TreeProblems;


import java.util.ArrayList;
import java.util.List;

class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        //List<Integer> nums = new ArrayList<Integer>();
        //nums.add(root.val);
        //return search(root, nums);
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int x){
        int y = x * 10 + root.val;
        if(root.left == null && root.right == null) return y;
        int a = 0;
        int b = 0;
        if(root.left != null) a = dfs(root.left, y);
        if(root.right != null) b = dfs(root.right, y);
        return a + b;
    }

    public int search(TreeNode root, List<Integer> nums) {
        nums.add(root.val);
        if(root.left == null && root.right == null) return getVal(nums);
        int a = 0;
        if(root.left != null) a = search(root.left, new ArrayList(nums));
        int b = 0;
        if(root.right != null) b = search(root.right, new ArrayList(nums));
        return a + b;
    }

    public int getVal(List<Integer> nums) {
        int sum = 0;
        int factor = 1;
        for(int i=nums.size() - 1; i>=0; i--){
            sum += factor * nums.get(i);
            factor *= 10;
        }
        return sum;
    }
}