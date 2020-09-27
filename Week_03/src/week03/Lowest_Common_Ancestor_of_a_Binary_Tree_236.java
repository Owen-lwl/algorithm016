package week02;
//236.二叉树的最近公共祖先
import javax.swing.tree.TreeNode;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Lowest_Common_Ancestor_of_a_Binary_Tree_236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        return left == null ? right : right == null ? left : root;
        /*最后一句代码的意思：
          if(left == null && right == null) return null;
          if(left != null && right != null) return root;
          return left == null ? right : left; */
    }
}
