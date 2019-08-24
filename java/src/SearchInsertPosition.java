import java.lang.reflect.Array;
import java.util.Arrays;

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] nums = {2};
        int target = 5;

        SearchInsertPosition test = new SearchInsertPosition();
        System.out.println(test.searchInsert(nums,target));
    }
}
