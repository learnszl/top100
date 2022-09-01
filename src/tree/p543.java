package tree;

/**
 * @Author szl
 * @Date 2022/3/8 20:13
 * @Description
 */
public class p543 {
    int res = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return res;
    }

    private int helper(TreeNode root) {
        if (root.left == null && root.right == null)
            return 0;
        int l = root.left == null ? 0 : helper(root.left) + 1;
        int r = root.right == null ? 0 : helper(root.right) + 1;
        res = Math.max(res, l + r);
        return Math.max(l, r);
    }
}
