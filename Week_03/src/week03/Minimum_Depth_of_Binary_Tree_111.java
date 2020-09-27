package week02;

//111.二叉树的最小深度
import java.util.LinkedList;
import java.util.Queue;

//递归法一:
/*
* 为何这里把 min_depth 设置为 Integer.MAX_VALUE ?
* 为了排除左右子树只有一棵为空的情况，这时候为空的子树深度为0，如果直接比较，
* 那结果肯定是0，但是因为有一个子树不为空，所以这个根节点不是叶子节点，所以
* 必须返回不为空的子树的最小深度加上根节点的1，因此将为空的子树的深度设置为
* Integer.MAX_VALUE，其实这时候不比较直接计算不为空的子树的最小深度也可以。
* */
public class Minimum_Depth_of_Binary_Tree_111 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int min_depth = Integer.MAX_VALUE;
        if (root.left != null) {
            min_depth = Math.min(minDepth(root.left), min_depth);
        }
        if (root.right != null) {
            min_depth = Math.min(minDepth(root.right), min_depth);
        }

        return min_depth + 1;
    }
}

//递归法二:
public class Minimum_Depth_of_Binary_Tree_111 {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        int m1 = minDepth(root.left);
        int m2 = minDepth(root.right);
        //1.如果左孩子和右孩子有为空的情况，直接返回m1 + m2 + 1
        //2.如果都不为空，返回较小深度+1
        return root.left == null || root.right == null ? m1 + m2 + 1 : Math.min(m1,m2) + 1;
    }
}

//广度优先遍历
/*
* 这题有时候 BFS 优于 DFS,
* 如果有一棵树，其中根的左子树的深度为 500，右子树的深度为 1，
* DFS 会先在 500 个左子树中向下遍历，最后再进行一个小步遍历右子树。
* 但使用 BFS 就不必遍历 501 个节点来确定最小深度，而只需遍历 2 个即可。
* */
public class Minimum_Depth_of_Binary_Tree_111 {
    class QueueNode {
        TreeNode node;
        int depth;

        public QueueNode(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<QueueNode> queue = new LinkedList<QueueNode>();
        queue.offer(new QueueNode(root, 1));
        while (!queue.isEmpty()) {
            QueueNode nodeDepth = queue.poll();
            TreeNode node = nodeDepth.node;
            int depth = nodeDepth.depth;
            if (node.left == null && node.right == null) {
                return depth;
            }
            if (node.left != null) {
                queue.offer(new QueueNode(node.left, depth + 1));
            }
            if (node.right != null) {
                queue.offer(new QueueNode(node.right, depth + 1));
            }
        }

        return 0;
    }
}
