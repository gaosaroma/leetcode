import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class UniqueBinarySearchTrees {
    // 动态规划
    public int numTrees(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int[] tmp = new int[n+1];
        tmp[0] = 1;
        tmp[1] = 1;
        tmp[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                tmp[i] += tmp[j] * tmp[i - j - 1];
            }
        }

        return tmp[n];
    }

    public static void main(String[] args) {
        UniqueBinarySearchTrees tmp = new UniqueBinarySearchTrees();
        System.out.println(tmp.numTrees(3));
    }
}
