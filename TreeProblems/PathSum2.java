package TreeProblems;

import java.util.ArrayList;
import java.util.List;

class PathSum2 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ret = new ArrayList<>();
        if(root == null) return ret;
        return search(root, sum, ret, 0, new ArrayList<Integer>());
    }
    public List<List<Integer>> search(TreeNode root, int sum, List<List<Integer>> ret, int curr, List<Integer> nodes) {
        curr += root.val;
        nodes.add(root.val);
        if(curr == sum && root.left == null && root.right == null){
            //System.out.println(nodes.size());
            ret.add(nodes);
            return ret;
        }
        if(root.left != null) ret.addAll(search(root.left, sum, new ArrayList<List<Integer>>(), curr, new ArrayList<Integer>(nodes)));
        if(root.right != null) ret.addAll(search(root.right, sum, new ArrayList<List<Integer>>(), curr, new ArrayList<Integer>(nodes)));
        return ret;
    }
}
