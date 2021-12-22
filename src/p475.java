import java.util.Arrays;

public class p475 {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int res = 0;
        for (int house : houses) {
            int pos = search(heaters, house);
//            System.out.println(pos);
            int l = pos - 1 >= 0 ? house - heaters[pos - 1] : Integer.MAX_VALUE;
            int r = pos < heaters.length ? Math.abs(heaters[pos] - house) : Integer.MAX_VALUE;
            int temp = Math.min(l, r);
//            System.out.println(temp);
            res = Math.max(res, temp);
        }
        return res;
    }

    private int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target)
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }

    public static void main(String[] args) {
        p475 p475 = new p475();
        System.out.println(p475.findRadius(new int[]{1, 5}, new int[]{2}));
    }
}
