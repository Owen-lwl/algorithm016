package week02;

import org.w3c.dom.Node;

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
public class N_ary_Tree_Preorder_Traversal_589 {
    public List<Integer> ans = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        if (root == null) return ans;
        ans.add(root.val);
        for (Node node : root.children) {
            preorder(node);
        }
        return ans;
    }
}
