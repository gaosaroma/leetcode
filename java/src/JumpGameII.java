public class JumpGameII {
    public int jump(int[] nums) {
//        这个题贪婪的对象是：每一步最大能走的范围。因为只要记录跳了几次，而每当跨越上一次最大的范围的时候，一定会多跳一次。
//        所以记录每一次能跳的最大范围，以及在这范围之间能够跳的、新的最大范围。如果最新的范围>上一次最大的范围，则多跳一次。
        if (nums.length < 2) return 0;

        int pos = 0;
        int maxReach = 0;
        int maxJump = 0;
        int count = 0;

        while (maxReach < nums.length - 1) {
            if (pos == maxReach) {
                maxJump = Math.max(maxJump, nums[pos]);
                maxReach += maxJump;
                count++;
                pos++;
                maxJump--;
            } else {
                maxJump = Math.max(maxJump, nums[pos]);
                pos++;
                maxJump--;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        JumpGameII test = new JumpGameII();
        int[] nums = {2,3,1,1,4};
        System.out.println(test.jump(nums));
    }
}
