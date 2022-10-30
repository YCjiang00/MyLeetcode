package dfs_bfs;

public class easy101 {
    /**
     * 给你一个二叉树的根节点 root ， 检查它是否轴对称
     */
    public boolean isSymmetric(TreeNode root) {
        return checktree(root, root);
    }

    private boolean checktree(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (right == null || left == null) {
            return false;
        }
        return left.val == right.val && checktree(left.left, right.right) && checktree(left.right, right.left);
    }
}
