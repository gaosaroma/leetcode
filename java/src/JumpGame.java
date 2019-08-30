import javax.swing.*;

public class JumpGame {
    public boolean canJump(int[] nums) {
        if (nums.length < 2) return true;

        int maxReach = 0;
        int maxJump = 0;
        int pos = 0;

        while (maxReach < nums.length - 1) {
            if (pos == maxReach) {
                maxJump = Math.max(maxJump, nums[pos]);
                if (maxJump == 0) return false;
                maxReach += maxJump;
                pos++;
                maxJump--;
            } else {
                maxJump = Math.max(maxJump, nums[pos]);
                pos++;
                maxJump--;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        JumpGame test = new JumpGame();

        int[] nums = {3,2,1,0,4};

        System.out.println(test.canJump(nums));
    }
}
