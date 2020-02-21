public class MaximumSubarray {
    // 动态规划
    // 找其中最大的
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;

        int[] max = new int[nums.length];
        int res = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                max[i] = nums[i];
            } else {
                max[i] = Math.max(max[i - 1] + nums[i], nums[i]);
            }

            if (res < max[i]) res = max[i];
        }
        return res;
    }

    public static void main(String[] args) {
        MaximumSubarray t = new MaximumSubarray();
        int[] a = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(t.maxSubArray(a));
    }
}
