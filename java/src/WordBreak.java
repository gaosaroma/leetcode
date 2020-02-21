import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    // 动态规划
    public boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict == null || wordDict.isEmpty()) return false;

        boolean[] dp = new boolean[s.length()];
        Set<Integer> lens = new HashSet<>();

        for (String str : wordDict) {
            lens.add(str.length());
        }

        for (int i = 1; i < s.length() + 1; i++) {
            for (int len : lens) {
                int j = i - len;

                if (j < 0) continue;
                String subStr = s.substring(j, i);
                if (wordDict.contains(subStr) && (j == 0 || dp[j - 1])) {
                    dp[i - 1] = true;
                    break;
                }

            }
        }

        return dp[s.length() - 1];
    }
}
