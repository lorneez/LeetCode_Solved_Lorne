package TreeProblems;

class LowestCommonAncestorOfABinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int larger;
        int smaller;
        if(p.val > q.val){
            larger = p.val;
            smaller = q.val;
        }
        else{
            larger = q.val;
            smaller = p.val;
        }
        while(true){
            if(root.val > larger){
                root = root.left;
            }
            else if(root.val < smaller){
                root = root.right;
            }
            else{
                return root;
            }
        }
    }
}