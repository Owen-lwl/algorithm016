package week02;
//226.翻转二叉树
import java.util.LinkedList;

//递归法一:
public class Invert_Binary_Tree_226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}

//递归法二:
public class Invert_Binary_Tree_226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode tempRight = root.right;
        root.right = invertTree(root.left);
        root.left = invertTree(tempRight);
        return root;
    }
}

//迭代法: (BFS)
public class Invert_Binary_Tree_226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return root;
    }
}
