import java.util.Arrays;
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        //        THOUGHTS: process flow
        //        1. to find the first decreasing number
        //        2. to find the larger number in the right rest
        //        3. swap them
        //        4. reverse the right rest
        //        NOTICE: boundary! like the [i-1],[i]; [j],[j+1]; like the ">=" or ">"

        int i = nums.length - 1;
        while (i >= 1 && nums[i - 1] >= nums[i]) {  // NOTICE: is ">=" not just ">"
            i--;
        }

        // if all numbers are decreasing
        if (i == 0) {
            this.reverse(nums, 0, nums.length - 1);
            return;
        }

        // else
        int j = i;
        int fir_idx = i - 1;
        while (j < nums.length && nums[j] > nums[fir_idx]) {
            j++;
        }

        int nex_idx = j - 1;
        swap(nums, fir_idx, nex_idx);
        reverse(nums, fir_idx + 1, nums.length - 1);

    }

    private void reverse(int[] nums, int fir_idx, int end_idx) {
        int lf = fir_idx;
        int rt = end_idx;
        while (lf < rt) {
            swap(nums, lf, rt);
            lf++;
            rt--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int nums[] = {1,5,1};
        NextPermutation test = new NextPermutation();
        test.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
