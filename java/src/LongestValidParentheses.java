public class LongestValidParentheses {
    // 动态规划
    // 个人觉得'DP'更加合适，最长的都是从上一个推过来的
    // 但这里要注意条件leftCount
    public int longestValidParentheses(String s) {
        int[] DP = new int[s.length()];
        int res = 0;
        int leftCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                leftCount++;
            } else if (leftCount > 0) {
                DP[i] = DP[i - 1] + 2;
                DP[i] += (i - DP[i]) >= 0 ? DP[i - DP[i]] : 0;

                res = Math.max(res, DP[i]);
                leftCount--;
            }
        }
        return res;

    }
}
