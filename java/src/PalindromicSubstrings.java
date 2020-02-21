import java.lang.reflect.Array;

public class PalindromicSubstrings {
    // 动态规划 [回文]

    public int countSubstrings(String s) {
        if (s.length() < 2) return s.length();

        int count = s.length();
        Boolean[][] DP = new Boolean[s.length()][s.length()];

        for (int len = 2; len < s.length() + 1; len++) {
            for (int i = 0; i < s.length() + 1 - len; i++) {
                int j = i + len - 1;

                if (len < 4) {
                    DP[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    DP[i][j] = s.charAt(i) == s.charAt(j) && DP[i + 1][j - 1];
                }
                if (DP[i][j]) {
                    count ++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        PalindromicSubstrings t= new PalindromicSubstrings();
        System.out.println(t.countSubstrings("abc"));
        System.out.println(t.countSubstrings("aaa"));
    }
}
