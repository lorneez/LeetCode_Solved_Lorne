package CTCI_Trees_And_Graphs.Leetcode;


import CTCI_Trees_And_Graphs.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        return recurse(root, false);
    }

    public int recurse(TreeNode root, boolean marker){
        if(root == null) return 0;
        if(marker && root.left == null && root.right == null){
            return root.val;
        }
        //int x = 0;
        //int y = 0;

        return recurse(root.left, true) + recurse(root.right, false);
    }
}