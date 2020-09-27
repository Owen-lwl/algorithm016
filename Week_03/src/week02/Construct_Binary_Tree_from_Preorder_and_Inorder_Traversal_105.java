package week02;
//105.从前序与中序遍历序列构造二叉树
import java.util.HashMap;
import java.util.Map;
/*
* 时间复杂度：O(N)
* 空间复杂度：O(N)。除去返回的答案需要的 O(N)空间之外，我们还需要使用 O(N)的空间存储哈希映射，以及 O(h)（其中 h 是树的高度）的空间表示递归时栈空间。
* 这里 h < N，所以总空间复杂度为 O(N)。
* */
public class Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal_105 {
    class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            int preLen = preorder.length;
            int inLen = inorder.length;
            if (preLen != inLen) throw new RuntimeException("Incorrect input data");
            Map<Integer, Integer> map = new HashMap<>(preLen);
            for (int i = 0; i < preLen; i++) {
                map.put(inorder[i], i);
            }
            return buildTree(preorder, 0, preLen - 1, map, 0, inLen - 1);
        }

        private TreeNode buildTree(int[] preorder, int preLeft, int preRight, Map<Integer, Integer> map, int inLeft, int inRight) {
            if (preLeft > preRight || inLeft > inRight) return null;
            int rootVal = preorder[preLeft];
            TreeNode root = new TreeNode(rootVal);
            int pIndex = map.get(rootVal);
            root.left = buildTree(preorder, preLeft + 1, pIndex - inLeft + preLeft, map, inLeft, pIndex - 1);
            root.right = buildTree(preorder, pIndex - inLeft + preLeft + 1, preRight, map, pIndex + 1, inRight);
            return root;
        }
    }
}
