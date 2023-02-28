package kim.fzp.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的最小深度
 * author fzp
 * date 2023/2/28 18:16
 */
public class Solution111_2 {
    class QueueNode {
        TreeNode node;

        int depth;

        public QueueNode(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    /**
     * 广度优先搜索
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<QueueNode> queue = new LinkedList<>();
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
