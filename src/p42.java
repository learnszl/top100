public class p42 {
    public int trap(int[] height) {
        int sum = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int left = i;
            for (int j = i - 1; j >= 0; j--) {
                if (height[j] > height[left]) {
                    left = j;
                }
            }
            int right = i;
            for (int j = i + 1; j < height.length; j++) {
                if (height[j] > height[right]) {
                    right = j;
                }
            }
            if (left != i && right != i) {
//                System.out.println("l:" + left + " r:" + right);
                sum = sum + Math.min(height[left], height[right]) - height[i];
            }
        }
        return sum;
    }

    public int trap1(int[] height) {
        int n = height.length, res = 0;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = height[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], height[i]);
        }
        right[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i]);
        }
        for (int i = 1; i < n - 1; i++) {
            res += Math.min(left[i], right[i]) - height[i];
        }
        return res;
    }

    public static void main(String[] args) {
        p42 p42 = new p42();
        System.out.println(p42.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(p42.trap1(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
