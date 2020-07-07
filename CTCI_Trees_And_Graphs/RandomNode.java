package CTCI_Trees_And_Graphs;

public class RandomNode {
    private TreeNode root;

    public static void main(String[] args){
        RandomNode test = new RandomNode(5);
        test.insert(3);
        test.insert(6);
        System.out.println(test.find(3));
        System.out.println(test.find(4));
        test.delete(6);
        System.out.println(test.find(6));
    }
    public RandomNode(int val) {
        root = new TreeNode(val);
    }

    public void insert(int val) {
        TreeNode front = root;
        TreeNode insert = new TreeNode(val);
        while(true) {
            if(front.val > val){
                if(front.left == null){
                    front.left = insert;
                    break;
                }
                front = front.left;
            }
            if(front.val < val) {
                if(front.right == null){
                    front = insert;
                    break;
                }
                front = front.right;
            }
        }
    }

    public boolean find(int val) {
        TreeNode front = root;
        while(true) {
            if(front == null) {
                return false;
            }
            if(front.val == val) {
                return true;
            }
            else if(front.val > val) {
                front = front.left;
            }
            else if(front.val < val) {
                front = front.right;
            }
        }
    }

    public void delete(int val) {
        searchAndDelete(val, root);
    }

    public TreeNode searchAndDelete(int val, TreeNode root) {
        // null
        if(root == null) return null;

        // search
        if(root.val > val){
            root.left = searchAndDelete(val, root.left);
        }
        else if(root.val < val){
            root.right = searchAndDelete(val, root.right);
        }
        // found key
        else {
            // leaf
            if(root.left == null && root.right == null) {
                root = null;
                return root;
            }
            // single child
            else if(root.left == null){
                return root.right;
            }
            else if(root.right == null) {
                return root.left;
            }
            // two children
            else if(root.left != null && root.right != null){
                TreeNode min = findMin(root.right);
                root.val = min.val;
                root.right = searchAndDelete(min.val, root.right);
            }
        }
        return root;
    }

    public TreeNode findMin(TreeNode root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }

    public TreeNode getRandomNode() {
        return new TreeNode(2);
    }
}
