package TreeProblems;


class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int l = height(root.left);
        int r = height(root.right);
        return l >= 0 && r >=0 && Math.abs(r-l) <= 1;
    }
    public int height(TreeNode root){
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        int l = height(root.left);
        int r = height(root.right);
        if (r < 0 || l < 0 || Math.abs(r-l) > 1) return -1;
        return Math.max(l, r) + 1;
    }
}
/*
if(root == null) return true;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 1;
        while(!q.isEmpty()){
            int size = q.size();
            boolean end = size == level ? false : true;
            for(int i = 0; i< size; i++){
                TreeNode x = q.peek();
                if(end && (x.left != null || x.right != null)){
                    return false;
                }
                if(x.left != null) q.add(x.left);
                if(x.right != null) q.add(x.right);
                q.poll();
            }
            level *= 2;
        }
        return true;

*/