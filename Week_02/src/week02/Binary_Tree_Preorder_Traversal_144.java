package week02;

import javax.swing.tree.TreeNode;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//Definition for a binary tree node.
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

//递归法一
public class Binary_Tree_Preorder_Traversal_144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        if (root == null) return ans;
        ans.add(root.val);
        ans.addAll(preorderTraversal(root.left));
        ans.addAll(preorderTraversal(root.right));
        return ans;
    }
}

//递归法二: 利用递归辅助函数
public class Binary_Tree_Preorder_Traversal_144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        preorder(root, ans);
        return ans;
    }

    public void preorder(TreeNode root, List<Integer> ans) {
        if (root == null) return;
        ans.add(root.val);
        preorder(root.left, ans);
        preorder(root.right, ans);
    }
}

/*
* 迭代法一: (使用栈)
* 时间复杂度：访问每个节点恰好一次，时间复杂度为 O(N)，其中 N 是节点的个数，也就是树的大小。
* 空间复杂度：取决于树的结构，最坏情况存储整棵树，因此空间复杂度是 O(N)。
* */
public class Binary_Tree_Preorder_Traversal_144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        if (root == null) return ans;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            ans.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left !=null) {
                stack.push(node.left);
            }
        }
        return ans;
    }
}

/*
* 迭代法二: (使用栈)
* */
public class Binary_Tree_Preorder_Traversal_144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        if (root == null) return ans;
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                ans.add(node.val);
                stack.push(node.right);
                node = node.left;
            }
            else {
                node = stack.pop();
            }
        }
        return ans;
    }
}