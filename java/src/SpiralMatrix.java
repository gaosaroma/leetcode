import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
//        找规律..大一的期末考试题目
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) return res;

        int h = matrix.length, w = matrix[0].length;
        int start = 0;
        int mount = h * w;
        while (true) {
            for (int j = start; j < w - start; j++) {
                res.add(matrix[start][j]);
            }
            if (mount == res.size()) break;
            for (int i = start + 1; i < h - start; i++) {
                res.add(matrix[i][w - start - 1]);
            }
            if (mount == res.size()) break;
            for (int j = w - start - 2; j > start - 1; j--) {
                res.add(matrix[h - start - 1][j]);
            }
            if (mount == res.size()) break;
            for (int i = h - start - 2; i > start; i--) {
                res.add(matrix[i][start]);
            }
            if (mount == res.size()) break;
            start++;
        }
        return res;
    }

    public static void main(String[] args) {
        SpiralMatrix test = new SpiralMatrix();
        int[][] nums = {{},{}};
        System.out.println(test.spiralOrder(nums));
    }
}
