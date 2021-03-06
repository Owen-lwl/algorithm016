package week02;

import java.util.ArrayList;
import java.util.List;

// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

//递归法
public class N_ary_Tree_Postorder_Traversal_590 {
    public List<Integer> ans = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        if (root == null) return ans;
        for (Node node : root.children) {
            postorder(node);
        }
        ans.add(root.val);
        return ans;
    }
}
