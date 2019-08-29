import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
                if (i > startIdx && nums[i - 1] == nums[i]) continue; // skip duplicates, 假设[i]与[i+1]相同，对于[j]在检查完[i]之后，应该跳过[i+1]，所以应该在backtrace的最前面进行判断+跳转。
                tmpList.add(nums[i]);
                backtrack(resList, tmpList, nums, remains - nums[i], i + 1);
                tmpList.remove(tmpList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        CombinationSum2 test = new CombinationSum2();

        int[] nums = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        List<List<Integer>> resList = test.combinationSum2(nums, target);
        System.out.println(Arrays.toString(resList.toArray()));
    }
}
