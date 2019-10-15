import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals.length < 2) return intervals;

        List<int[]> resList = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]));

        for (int i = 0; i < intervals.length; i++) {
            
        }

        return resList.toArray(new int[resList.size()][]);
    }

    public static void main(String[] args) {
        int[][] nums = {{15, 18}, {2, 6}, {1, 3}, {15, 16}, {8, 10}};
        MergeIntervals test = new MergeIntervals();
        test.merge(nums);
        System.out.println(Arrays.deepToString(nums));
    }
}
