package TreeProblems;

class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        if(root==null) return;
        flatten(root.left);
        flatten(root.right);
        TreeNode l = root.left;
        TreeNode r = root.right;
        root.right = l;
        root.left = null;
        while(root.right != null){
            root = root.right;
        }
        root.right = r;
    }
}
