public class MaximumProductSubarray {
    // 求动态的最大值：动态规划
    // 最大值由两部分组成：有我，没我
    // 关键有负数，最大和最小总是在相互转换，所以把最大和最小都存下来，在求最大值时，要注意反转
    /*
    idea is to keep 3 variables
    1. max -> maximum product ending at a[i]
    2. min -> minimum product ending at a[i]
    3. ans -> maximum product subarray

    Ex.
    num = [3, 2, -1,   5, -2]
    min = [3, 2, -6, -30, -2]
    max = [3, 6, -1,   5, 60]
    ans = [3, 6,  6,   6, 60]
    */
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = nums[0];
        int min = nums[0];
        int ans = nums[0];
        int temp;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                temp = max;
                max = min;
                min = temp;
            }
            max = Integer.max(nums[i], nums[i] * max);
            min = Integer.min(nums[i], nums[i] * min);
            ans = Integer.max(ans, max);
        }
        return ans;
    }

    public static void main(String[] args) {
        MaximumProductSubarray t = new MaximumProductSubarray();
        int[] a = {-4, -3};
        System.out.println(t.maxProduct(a));
    }
}
