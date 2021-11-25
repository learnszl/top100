

public class jz3 {
    public int findRepeatNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (i == nums[i]) {
                i++;
                continue;
            }
            if (nums[i] == nums[nums[i]])
                return nums[i];
            int x = nums[i];
            nums[i] = nums[nums[i]];
            nums[nums[i]] = x;
        }
        return -1;
    }


}
