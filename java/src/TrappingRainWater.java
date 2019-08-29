import java.util.Arrays;

public class TrappingRainWater {
    public int trap(int[] height) {
        // 核心在：放两个指针，根据蓄水的规律，蓄水
        if (height.length < 3) return 0;

        int l = 0, r = height.length - 1;
        int res = 0;

        while (l < r && height[l] <= height[l + 1]) l++; // 找左边最高的
        while (l < r && height[r] <= height[r - 1]) r--; // 找右边最高的

        while (l < r) {
            if (height[l] <= height[r]) { // 找每一段蓄水的
                int l_max = l;
                while (l < r && height[l_max] >= height[++l]) {
                    res += height[l_max] - height[l];
                }
            } else {
                int r_max = r;
                while (l < r && height[r_max] >= height[--r]) {
                    res += height[r_max] - height[r];
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TrappingRainWater test = new TrappingRainWater();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(test.trap(height));
    }
}
