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
class LongestUnivaluePath {
    int max;
    public int longestUnivaluePath(TreeNode root) {
        if(root == null) return 0;
        search(root, 0);
        return max;
    }

    public int search(TreeNode root, int previousVal){
        if(root == null) return 0;

        int left = search(root.left, root.val);
        int right = search(root.right, root.val);

        max = Math.max(max, left + right);

        if(root.val == previousVal){
            return Math.max(right,left) + 1;
        }
        return 0;
    }
}
