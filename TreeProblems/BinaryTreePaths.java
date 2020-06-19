package TreeProblems;


import java.util.ArrayList;
import java.util.List;

class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> x = new ArrayList<>();
        if(root == null) return x;
        return search(root, x, "");
    }

    public List<String> search(TreeNode root, List<String> x, String s){
        if(s.length() == 0){
            s = "" + root.val;
        }
        else {
            s = s + "->" + root.val;
        }
        if(root.left == null && root.right == null){
            x.add(s);
            return x;
        }
        if(root.left != null){
            x = search(root.left, x, s);
        }
        if(root.right != null){
            x = search(root.right, x, s);

        }
        return x;
    }
}