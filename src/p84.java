import java.util.Stack;

public class p84 {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length, res = 0;
        int[] helper = new int[n + 2];
        Stack<Integer> stack = new Stack<>();
        System.arraycopy(heights, 0, helper, 1, n);
        for (int i = 0; i < helper.length; i++) {
            while (!stack.isEmpty() && helper[i] < helper[stack.peek()]) {
                int curr = stack.pop();
                res = Math.max(res, (i - stack.peek() - 1) * helper[curr]);
//                System.out.println(res);
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        p84 p84 = new p84();
        System.out.println(p84.largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }
}
