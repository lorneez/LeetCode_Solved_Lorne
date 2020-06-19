package TreeProblems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        //return help1(root);
        return help2(root);
    }

    public List<List<Integer>> help2(TreeNode root){
        List<List<Integer>> myList = new ArrayList<>();
        if(root == null) return myList;

        Queue<TreeNode> myQueue = new LinkedList<>();
        myQueue.add(root);

        while(!myQueue.isEmpty()){
            int size = myQueue.size();
            List<Integer> temp = new ArrayList<>();
            for(int i=0; i<size; i++){
                TreeNode x = myQueue.peek();
                if(x.left != null) myQueue.add(x.left);
                if(x.right != null) myQueue.add(x.right);
                temp.add(x.val);
                myQueue.poll();
            }
            myList.add(temp);
        }
        return myList;

    }

    public List<List<Integer>> help1(TreeNode root){
        List<List<Integer>> myList = new ArrayList<>();
        Queue<TreeNode> myQueue = new LinkedList<>();
        myQueue.add(root);
        if(root == null) return myList;
        List<Integer> first = new ArrayList<>();
        first.add(root.val);
        myList.add(first);

        List<TreeNode> nodes = new ArrayList<>();
        List<Integer> vals = new ArrayList<>();

        while(!myQueue.isEmpty()){
            TreeNode x = myQueue.remove();
            if(x.left != null) {
                vals.add(x.left.val);
                nodes.add(x.left);
            }
            if(x.right != null) {
                vals.add(x.right.val);
                nodes.add(x.right);
            }
            if(myQueue.isEmpty() && nodes.size() != 0){
                myQueue.addAll(nodes);
                nodes.clear();
                List<Integer> pair = new ArrayList<>();
                for(int i=0; i<vals.size(); i++){

                    pair.add(vals.get(i));
                }
                myList.add(pair);
                vals.clear();
            }
        }
        return myList;
    }
}