package TreeProblems;

class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        return check(root, sum, 0);
    }

    public boolean check(TreeNode root, int sum, int curr){
        curr += root.val;
        if(root.left == null && root.right == null){
            if(sum == curr) return true;
            return false;
        }
        boolean l = false;
        boolean r = false;
        if(root.left != null) l = check(root.left, sum, curr);
        if(root.right != null) r = check(root.right, sum, curr);
        return l || r;
    }
}