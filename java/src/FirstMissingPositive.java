import java.util.Arrays;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
//        The key here is to use swapping to keep constant space and also make use of the length of the array,
//        which means there can be at most n positive integers. So each time we encounter an valid integer,
//        find its correct position and swap. Otherwise we continue.
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] < nums.length && nums[nums[i] - 1] != nums[i]) {
                swap(nums, nums[i] - 1, i);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - 1 != i) return i + 1;
        }
        return nums.length + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        FirstMissingPositive test = new FirstMissingPositive();
        int[] nums = {-1,4,7,2,3,1};
        System.out.println(test.firstMissingPositive(nums));
        System.out.println(Arrays.toString(nums));
    }
}
