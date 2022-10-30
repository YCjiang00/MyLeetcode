package dfs_bfs;


import java.util.ArrayDeque;
import java.util.Queue;

public class easy112 {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        /**
         * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。
         * 判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。
         * 如果存在，返回 true ；否则，返回 false
         */

        // DFS
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }


    public boolean hasPathSum1(TreeNode root, int targetSum) {
        // BFS
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queNode = new ArrayDeque<>();
        Queue<Integer> queVal = new ArrayDeque<>();
        queNode.offer(root);
        queVal.offer(root.val);
        while (!queNode.isEmpty()) {
            TreeNode now = queNode.poll();
            int temp = queVal.poll();
            if (now.right == null && now.left == null) {
                if (targetSum == temp) {
                    return true;
                }
                continue;
            }
            if (now.left != null) {
                queNode.offer(now.left);
                queVal.offer(now.left.val + temp);

            }
            if (now.right != null) {
                queNode.offer(now.right);
                queVal.offer(now.right.val + temp);
            }
        }
        return false;
    }
}
