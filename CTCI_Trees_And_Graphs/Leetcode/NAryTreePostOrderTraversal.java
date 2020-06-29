package CTCI_Trees_And_Graphs.Leetcode;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;





class NAryTreePostOrderTraversal {
    private List<Integer> values = new ArrayList<Integer>();

    public List<Integer> postorder(Node root) {
        //return recursiveFast(root);
        return recursive(root, new ArrayList<Integer>());
        //return iterative(root);
        //return iterativeFast(root);
    }

    public List<Integer> recursive(Node root, List<Integer> vals) {
        ArrayList x = new ArrayList<Integer>();
        if(root == null){
            return x;
        }
        for(Node n : root.children){
            if(n.children !=null) x.addAll(recursive(n,new ArrayList<Integer>()));
        }
        x.add(root.val);
        vals.addAll(x);
        return vals;
    }

    public List<Integer> recursiveFast(Node root){
        if(root != null){
            visit(root);
        }
        return values;
    }

    public void visit(Node root){
        for(Node n : root.children){
            visit(n);
        }
        values.add(root.val);
    }

    public List<Integer> iterative(Node root) {
        List<Integer> ret = new ArrayList<>();
        if(root == null) return ret;
        Stack<Node> x = new Stack<>();
        x.push(root);
        Stack<Integer> ints = new Stack<>();

        while(!x.isEmpty()) {
            Node p = x.pop();
            ints.push(p.val);
            for(Node n : p.children){
                x.push(n);
            }
        }
        while(!ints.isEmpty()){
            ret.add(ints.pop());
        }
        return ret;
    }

    public List<Integer> iterativeFast(Node root) {
        List<Integer> ans = new LinkedList();
        if (root == null) return ans;
        Stack<Node> stack = new Stack();
        Node last = null;
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.peek();
            if (cur == last || cur.children.size() > 0 && cur.children.contains(last)) {
                cur = stack.pop();
                ans.add(cur.val);
            } else {
                for (int i = cur.children.size() - 1; i >= 0; i--) {
                    stack.push(cur.children.get(i));
                }
            }
            last = cur;
        }
        return ans;
    }
}