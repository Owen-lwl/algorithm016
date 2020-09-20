package week02;

import java.util.LinkedList;
import java.util.List;

//Definition for a binary tree node.
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

//递归法一
public class Binary_Tree_Postorder_Traversal_145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        if (root == null) return ans;
        ans.addAll(postorderTraversal(root.left));
        ans.addAll(postorderTraversal(root.right));
        ans.add(root.val);
        return ans;
    }
}

//递归法二
public class Binary_Tree_Postorder_Traversal_145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        postorder(root, ans);
        return ans;
    }

    public void postorder(TreeNode root, List<Integer> ans) {
        if (root == null) return;
        postorder(root.left, ans);
        postorder(root.right, ans);
        ans.add(root.val);
    }
}

/*
* 迭代法
* 时间复杂度：访问每个节点恰好一次，因此时间复杂度为 O(N)，其中 NN 是节点的个数，也就是树的大小。
* 空间复杂度：取决于树的结构，最坏情况需要保存整棵树，因此空间复杂度为 O(N)。
* */
public class Binary_Tree_Postorder_Traversal_145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        //是LinkedList<Integer>而不是List<Integer>
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }

        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            output.addFirst(node.val);
            if (node.left != null) {
                stack.add(node.left);
            }
            if (node.right != null) {
                stack.add(node.right);
            }
        }
        return output;
    }
}