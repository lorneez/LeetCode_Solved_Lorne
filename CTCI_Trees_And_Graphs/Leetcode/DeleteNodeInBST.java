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

class DeleteNodeInBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(root.val == key){
            TreeNode temp = new TreeNode(0);
            temp.left = root;
            delete(temp, root, 0);
            return temp.left;
        }
        search(root, key);
        return root;
    }
    public void search(TreeNode root, int key){
        while(true){
            if(root.left == null && root.right == null) break;
            if(root.left != null && root.left.val == key){
                delete(root, root.left, 0);
                break;
            }
            else if(root.right != null && root.right.val == key){
                delete(root, root.right, 1);
                break;
            }
            else if(root.val > key){
                root = root.left;
            }
            else {
                root = root.right;
            }
        }
    }

    public void delete(TreeNode root, TreeNode del, int indicator){
        if(childCount(del) == 0){
            //System.out.println("delete leaf");
            if(indicator == 0){
                root.left = null;
            }
            else{
                root.right = null;
            }
        }
        else if(childCount(del) == 1){
            //System.out.println("delete leaf with one child");
            if(indicator == 0){
                if(del.left != null){
                    root.left = del.left;
                }
                else {
                    root.left = del.right;
                }
            }
            else{

                if(del.left != null){
                    root.right = del.left;
                }
                else {
                    root.right = del.right;
                }
            }
        }
        else{
            //System.out.println("delete leaf with two children");
            //System.out.println(del.val);
            int min = deleteAndReturnMin(del, del.right);
            //System.out.println("found min: " + min);
            del.val = min;
            //search(del, min);
        }
    }

    public int childCount(TreeNode leaf){
        int count = 0;
        if(leaf.left != null) count ++;
        if(leaf.right != null) count ++;
        return count;
    }

    public int deleteAndReturnMin(TreeNode parent, TreeNode child){
        int min;
        int direction = 1;

        while(true) {
            min = child.val;
            if(child.left != null){
                direction = 0;
                parent = child;
                child = child.left;
            }
            else{
                break;
            }
        }
        //System.out.println(parent.val + " " + child.val);
        delete(parent, child, direction);
        return min;
    }
    public int findMax(TreeNode root){
        int max = Integer.MIN_VALUE;
        TreeNode temp = root;
        while(true){
            if(temp == null) break;
            max = Math.max(max, root.val);
            if(temp.right == null){
                temp = temp.left;
            }
            else{
                temp = temp.right;
            }
        }
        return max;
    }
}
