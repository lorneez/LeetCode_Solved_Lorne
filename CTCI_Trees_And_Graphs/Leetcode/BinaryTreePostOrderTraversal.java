package CTCI_Trees_And_Graphs.Leetcode;

import CTCI_Trees_And_Graphs.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class BinaryTreePostOrderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        if(root == null) return values;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode popped = stack.pop();
            values.add(0, popped.val);
            if(popped.left != null) stack.push(popped.left);
            if(popped.right != null) stack.push(popped.right);
        }
        return values;
    }
}