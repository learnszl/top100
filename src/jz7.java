import java.util.HashMap;
import java.util.function.IntUnaryOperator;

public class jz7 {
    HashMap<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return dfs(preorder, 0, 0, inorder.length - 1);
    }

    private TreeNode dfs(int[] preorder, int root, int left, int right) {
        if (left > right)
            return null;
        TreeNode node = new TreeNode(preorder[root]);
        int index = map.get(preorder[root]);
        node.left = dfs(preorder, root + 1, left, index - 1);
        node.right = dfs(preorder, root + (index - left) + 1, index + 1, right);
        return node;
    }

    /**
     * @param A
     * @param B
     * @return jz26
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null)
            return false;
        return helper26(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean helper26(TreeNode A, TreeNode B) {
        if (B == null)
            return true;
        if (A == null || A.val != B.val)
            return false;
        return helper26(A.left, B.left) && helper26(A.right, B.right);
    }

    /**
     * @param root
     * @return jz27
     */
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }

    /**
     * @param root
     * @return jz28
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return helper28(root.left, root.right);
    }

    private boolean helper28(TreeNode left, TreeNode right) {
        if (left == null || right == null)
            return left == null && right == null;
        if (left.val != right.val)
            return false;
        return helper28(left.left, right.right) && helper28(left.right, right.left);
    }

}