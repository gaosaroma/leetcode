import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        Approach: backtrack
        List<List<Integer>> resList = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(resList, new ArrayList<>(), candidates, target, 0);
        return resList;

    }

    private void backtrack(List<List<Integer>> resList, List<Integer> tmpList, int[] nums, int remains, int startIdx) {
        if (remains < 0) return;
        else if (remains == 0) resList.add(new ArrayList<>(tmpList));
        else {
            for (int i = startIdx; i < nums.length; i++) {
                tmpList.add(nums[i]);
                backtrack(resList, tmpList, nums, remains - nums[i], i);
                tmpList.remove(tmpList.size() - 1);
            }
        }

    }

    public static void main(String[] args) {
        CombinationSum test = new CombinationSum();
        int[] nums = {2,3,5};
        int target = 8;
        List<List<Integer>> resList = test.combinationSum(nums,target);
        System.out.println(Arrays.toString(resList.toArray()));
    }
}
