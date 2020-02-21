public class HouseRobber {
    // 动态规划
    // 状态i是由状态i-1与i-2来的
    public int rob(int[] nums) {
        if (nums.length == 0 || nums == null) return 0;
        int[] robs = new int[nums.length];
        int ans = nums[0];
        robs[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            robs[i] = Math.max(i > 1 ? nums[i] + robs[i - 2] : nums[i], robs[i - 1]);
            ans = Math.max(ans, robs[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        HouseRobber t = new HouseRobber();
        int[] y = {2, 7, 9, 3, 1};
        System.out.println(t.rob(y));
    }
}
