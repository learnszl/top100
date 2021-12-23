public class p11 {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1, res = 0;
        while (left < right) {
            if (height[left] > height[right]) {
                res = Math.max(res, (right - left) * height[right]);
                right--;
            } else {
                res = Math.max(res, (right - left) * height[left]);
                left++;
            }
        }
        return res;
    }
}
