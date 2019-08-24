import java.util.Arrays;

public class FindFirstandLastPositionofElementinSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int[] res = {-1, -1};

        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                int res0 = mid, res1 = mid;
                while (res0 > 0 && nums[res0 - 1] == nums[res0]) {
                    res0--;
                }
                while (res1 < nums.length - 1 && nums[res1] == nums[res1 + 1]) {
                    res1++;
                }
                res[0] = res0;
                res[1] = res1;
                return res;
            }

            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }

        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2,2};
        int target = 2;

        FindFirstandLastPositionofElementinSortedArray test = new FindFirstandLastPositionofElementinSortedArray();
//        System.out.println(test.searchRange(nums,target)); 这个输出的是返回数组（对象）的内存代号
        System.out.println(Arrays.toString(test.searchRange(nums,target)));
    }
}
