package CTCI_Trees_And_Graphs.Leetcode;

import CTCI_Trees_And_Graphs.TreeNode;

// i need to learn more about recusing through a tree while performing certain functions and calculations

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
class MaxProductOfSplitBinaryTree {
    long max;
    public int maxProduct(TreeNode root) {
        max = (long) 0;
        maxProduct(root, sum(root));
        return (int) (max % 1000000007);
    }

    public int sum(TreeNode root) {
        if(root == null) return 0;
        return root.val + sum(root.left) + sum(root.right);
    }

    public int maxProduct(TreeNode root, long total_sum) {
        if(root == null) return 0;
        int sum = root.val + maxProduct(root.left, total_sum) + maxProduct(root.right, total_sum);
        long product = (long) sum * (long) (total_sum - sum);
        max = Math.max(max, product);
        return sum;



    }
}
