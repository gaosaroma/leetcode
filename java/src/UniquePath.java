public class UniquePath {

    public int solution(int m, int n) {
        int[][] table = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i==0||j==0) table[i][j]=1;
                else table[i][j] = table[i - 1][j] + table[i][j - 1];
            }
        }
        return table[m-1][n-1];

    }

    public static void main(String[] args) {
        UniquePath t = new UniquePath();
        int m =7,n=3;
        System.out.println(t.solution(m,n));
    }
}