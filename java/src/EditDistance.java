public class EditDistance {
    // 动态规划
    // 修改[i][j]的步骤是由修改的[i-1][j-1]，[i-1][j]]，[i][j-1]子问题而来的
    // 也要考虑word1=''或者word2=''的情况，所以是dp[word1.length() + 1][word2.length() + 1];

    public int minDistance(String word1, String word2) {
        int dp[][] = new int[word1.length() + 1][word2.length() + 1];
        // 从无到有
        for (int i = 0; i < word1.length(); i++)
            dp[i + 1][0] = i + 1;
        for (int i = 0; i < word2.length(); i++)
            dp[0][i + 1] = i + 1;

        // 更新dp
        for (int i = 0; i < word1.length(); i++) {
            for (int j = 0; j < word2.length(); j++) {
                if (word1.charAt(i) == word2.charAt(j))
                    dp[i + 1][j + 1] = dp[i][j];
                else
                    dp[i + 1][j + 1] = Math.min(Math.min(dp[i][j + 1], dp[i + 1][j]) + 1, dp[i][j] + 1);
            }
        }
        return dp[word1.length()][word2.length()];

    }

}
