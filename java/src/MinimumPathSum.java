
public class MinimumPathSum {
    public int solution(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] table = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    table[i][j] = grid[i][j];
                    continue;
                }

                if (i == 0) {
                    table[i][j] = table[i][j - 1] + grid[i][j];
                    continue;
                }

                if (j == 0) {
                    table[i][j] = table[i - 1][j] + grid[i][j];
                    continue;
                }
                table[i][j] = Math.min(table[i - 1][j], table[i][j - 1]) + grid[i][j];

            }
        }
        return table[m - 1][n - 1];
    }

    public static void main(String[] args) {
        MinimumPathSum t = new MinimumPathSum();
        int[][] g = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println(t.solution(g));
    }
}
