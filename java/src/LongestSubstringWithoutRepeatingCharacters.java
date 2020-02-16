import java.util.HashMap;

// 查重，嗯，滑动窗口，嗯，别着急...
// 本质是两个指针在移动
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {

        HashMap<Character, Integer> tmp = new HashMap<>();
        int longest = 0;
        int leftMax = 0;

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);

            // 重复的时候挪leftMax
            if (tmp.containsKey(c)) {
                leftMax = Math.max(leftMax, tmp.get(c) + 1);
            }
            longest = Math.max(longest, i - leftMax + 1);

            tmp.put(c, i);
        }

        return longest;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters t = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(t.lengthOfLongestSubstring("ohomm"));
    }
}
