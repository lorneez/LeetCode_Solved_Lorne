package CTCI_Trees_And_Graphs.Leetcode;

import CTCI_Trees_And_Graphs.TreeNode;

import java.util.ArrayList;
import java.util.List;

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
class PathSum3 {

    public int pathSum(TreeNode root, int sum) {
        return search(root, new ArrayList<Integer>(), sum);
    }

    public int search(TreeNode root, List<Integer> vals, int sum) {
        if(root == null) return 0;
        int v = 0;
        vals.add(0);
        //vals.add(root.val);
        //System.out.println("---");
        for(int i=0; i<vals.size(); i++){
            //System.out.println(vals.get(i) + root.val);
            vals.set(i, vals.get(i) + root.val);
            if(vals.get(i) == sum){
                v++;
                //System.out.println("found " + root.val);
            };
        }
        return v + search(root.left, new ArrayList(vals), sum) + search(root.right, new ArrayList(vals), sum);
    }
}
