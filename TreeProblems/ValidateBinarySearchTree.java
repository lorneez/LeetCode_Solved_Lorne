package TreeProblems;

import java.util.LinkedList;
import java.util.Stack;

class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return check(root, null, null);
    }

    public boolean check(TreeNode root, Integer lower, Integer upper){
        if(root == null) return true; // return true because it is a binary search tree

        if(lower != null && root.val <= lower) return false; // if root val is lower than the lower, return false
        if(upper != null && root.val >= upper) return false; // if root val is higher than upper , return false

        if(!check(root.left, lower, root.val)) return false; // check left side. the upper is the root.val and the left is lower.
        if(!check(root.right, root.val, upper)) return false; // check right side, the lower is root.val while upper is upper.
        return true;
    }

//    public boolean BFS(TreeNode root){
//        Stack<TreeNode> bfs = new Stack<TreeNode>();
//        bfs.add(root);
//        while(bfs.size() != 0){
//            TreeNode x = bfs.pop();
//            if(x.left != null) bfs.add(x.left);
//            if(x.right != null) bfs.add(x.right);
//        }
//        return true;
//    }
}