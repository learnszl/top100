/**
 * @Author szl
 * @Date 2022/4/20 10:44
 * @Description
 */
public class huawei {
//    给定一棵二叉树(保证非空)以及这棵树上的两个节点对应的val值 o1 和 o2，请找到 o1 和 o2 的最近公共祖先节点。
//
//    数据范围：树上节点数满足 1≤n≤100000
//            , 节点值val满足区间 [0,n)
//    要求：时间复杂度 O(n)O(n)
//            import java.util.*;


    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }


    public class Solution {
        /**
         * @param root TreeNode类
         * @param o1   int整型
         * @param o2   int整型
         * @return int整型
         */
        public int lowestCommonAncestor(TreeNode root, int o1, int o2) {
            if (root.val == o1 || root.val == o2) {
                return root.val;
            }
            int left = lowestCommonAncestor(root.left, o1, o2);
            int right = lowestCommonAncestor(root.right, o1, o2);
            if (root.left.val == left) {
                return left;
            } else if (root.right.val == right) {
                return right;
            }else
                return root.val;
            // write code here
        }


    }
}
