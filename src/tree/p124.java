package tree;

/**
 * @Author szl
 * @Date 2022/3/8 20:26
 * @Description
 */
public class p124 {
    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return res;
    }

    private int helper(TreeNode root) {
        if (root == null)
            return 0;
        int l = Math.max(0, helper(root.left));
        int r = Math.max(0, helper(root.right));
        res = Math.max(res, l + r -  root.val);
        return Math.max(l, r) + root.val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        p124 p124 = new p124();
        System.out.println(p124.maxPathSum(root));
    }
}
