
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;

public class jz7 {
    int[] preorder;
    HashMap<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        this.preorder = preorder;
        return build(0, 0, preorder.length - 1);
    }

    private TreeNode build(int root, int left, int right) {
        if (left > right)
            return null;
        TreeNode node = new TreeNode(preorder[root]);
        int index = map.get(preorder[root]);
        node.left = build(root + 1, left, index - 1);
        node.right = build(root + index - left + 1, index + 1, right);
        return node;
    }
}
