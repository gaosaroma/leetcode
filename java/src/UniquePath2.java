public class UniquePath2 {
    public int solution(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) return 0;

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] table = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    table[i][j] = 0;

                } else {
                    if (i == 0 && j == 0) {
                        table[i][j] = 1;
                        continue;
                    }

                    if (i == 0) {
                        table[i][j] = table[i][j - 1];
                        continue;
                    }

                    if (j == 0) {
                        table[i][j] = table[i - 1][j];
                        continue;
                    }

                    table[i][j] = table[i - 1][j] + table[i][j - 1];

                }
            }
        }
        return table[m - 1][n - 1];
    }

    public static void main(String[] args) {
        UniquePath2 t = new UniquePath2();
        int[][] tgrid = {{1, 0}};

        System.out.println(t.solution(tgrid));
    }
}
