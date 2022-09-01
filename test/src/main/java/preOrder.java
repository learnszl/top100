import java.util.Arrays;

/**
 * @Author szl
 * @Date 2022/3/11 11:11
 * @Description
 */
public class preOrder {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode arrayToTree(int[] nums) {
        if (nums.length == 0)
            return null;
        return buildTree(nums);
    }

    private TreeNode buildTree(int[] nums) {
        TreeNode root = new TreeNode(nums[0]);
        int pos = findPos(nums);
        root.left = buildTree(Arrays.copyOfRange(nums, 1, pos));
        root.right = buildTree(Arrays.copyOfRange(nums, pos, nums.length));
        return root;
    }

    private int findPos(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[0])
                return i;
        }
        return 0;


    }

    public static void main(String[] args) {

    }
}
