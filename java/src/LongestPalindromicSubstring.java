public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
//        动态规划，考虑DP[i][j]与DP[i + 1][j - 1]之间的关系

        if (s.length() < 2) {
            return s;
        }
        boolean[][] DP = new boolean[s.length()][s.length()];
        int max_len = 1;
        int startPos = 0;

        // 避免考虑奇数和偶数，可以直接用len做循环
        // 也可以用num做循环，考虑奇数和偶数
        for (int _len = 2; _len < s.length() + 1; _len++) {
            int i = 0;
            while (i + _len < s.length() + 1) {
                int j = i + _len - 1;

                if (_len <= 3) {
                    DP[i][j] = s.charAt(i) == s.charAt(j); // odd and even
                } else {
                    DP[i][j] = s.charAt(i) == s.charAt(j) && DP[i + 1][j - 1];
                }

                if (DP[i][j] && _len > max_len) {
                    max_len = _len;
                    startPos = i;
                }

                i++;
            }
        }

        return s.substring(startPos, startPos + max_len);
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring test = new LongestPalindromicSubstring();
        String s = "aaaa";
        String r = test.longestPalindrome(s);
        System.out.println(r);
    }
}