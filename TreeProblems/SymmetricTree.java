package TreeProblems;


class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) return true;
        return check(root.left, root.right);
    }

    public boolean check(TreeNode left, TreeNode right){
        if(left == null && right == null) return true;
        else if(left != null  && right != null){
            if(left.val != right.val) return false;
            return check(left.left, right.right) && check(left.right, right.left);
        }
        else{
            return false;
        }
    }
}