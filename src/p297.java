import java.util.ArrayDeque;

import java.util.LinkedList;
import java.util.Queue;

public class p297 {
    public String serialize(TreeNode root) {
        if (root == null)
            return "";
        StringBuffer sb = new StringBuffer();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr == null) {
                sb.append("null,");
            } else {
                sb.append(curr.val).append(",");
                q.offer(curr.left);
                q.offer(curr.right);
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0)
            return null;
        String[] nodes = data.split(",");
        Queue<TreeNode> q = new ArrayDeque<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        q.offer(root);
        int i = 1;
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (nodes[i].equals("null")) {
                curr.left = null;
            } else {
                curr.left = new TreeNode(Integer.parseInt(nodes[i]));
                q.offer(curr.left);
            }
            i++;
            if (nodes[i].equals("null")) {
                curr.right = null;
            } else {
                curr.right = new TreeNode(Integer.parseInt(nodes[i]));
                q.offer(curr.right);
            }
            i++;
        }
        return root;
    }
}
