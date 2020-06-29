package CTCI_Trees_And_Graphs.Leetcode;

import CTCI_Trees_And_Graphs.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

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
class FindModeInBST {
    public int[] findMode(TreeNode root) {
        return stack(root);
    }

    public int[] stack(TreeNode root) {
        int[] none = {};
        if(root == null) return none;
        Map<Integer, Integer> counts = new HashMap<>();

        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        int max = 0;

        while(!s.isEmpty()){
            TreeNode x = s.pop();
            counts.put(x.val, counts.getOrDefault(x.val,0) + 1);
            if(counts.get(x.val) > max) max = counts.get(x.val);
            if(x.left != null) s.push(x.left);
            if(x.right != null) s.push(x.right);
        }

        ArrayList<Integer> k = new ArrayList<>();
        for(int key : counts.keySet()){
            if(counts.get(key) == max){
                k.add(key);
            }
        }
        return k.stream().mapToInt(i -> i).toArray();

    }
}


