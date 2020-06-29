package CTCI_Trees_And_Graphs.Leetcode;


import CTCI_Trees_And_Graphs.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
class AverageOfLevelsInBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> avgs = new ArrayList<>();
        if(root == null){
            return avgs;
        }
        Queue<TreeNode> x = new LinkedList<>();
        x.add(root);
        while(!x.isEmpty()){
            long avg = 0;
            int size = x.size();
            //List<TreeNode> level = new ArrayList<>();
            for(int i=0; i<size; i++){
                TreeNode t = x.remove();
                if(t.left != null){
                    x.add(t.left);
                }
                if(t.right != null){
                    x.add(t.right);
                }
                avg += t.val;
            }
            double ad = (double) avg/size;
            avgs.add(ad);
            //x.addAll(level);
        }
        return avgs;
    }


}