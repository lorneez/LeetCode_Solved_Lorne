class DeepestLeavesSum {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }

    public int deepestLeavesSum(TreeNode root) {
        int depth = findDeepest(root, 0);
        return findSum(root, 0, depth);
    }

    private int findDeepest(TreeNode root, int depth){
        TreeNode temp = root;
        int l = depth;
        int r = depth;
        if(temp != null){
            if(temp.left!=null) l = findDeepest(temp.left, depth + 1);
            if(temp.right!=null) r = findDeepest(temp.right, depth + 1);
        }
        return Math.max(l,r);
    }

    private int findSum(TreeNode root, int depth, int deepest){
        TreeNode temp = root;
        int l = 0;
        int r = 0;
        if(temp != null){
            if(temp.left!=null) l = findSum(temp.left, depth + 1, deepest);
            if(temp.right!=null) r = findSum(temp.right, depth + 1, deepest);
            if(depth == deepest) return temp.val;
            if(depth != deepest) return l + r;
        }
        else{
            return 0;
        }
        return 0;
    }
}