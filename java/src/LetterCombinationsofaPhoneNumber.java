import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsofaPhoneNumber {
    // 回溯法
    // 经典的组合问题[M*N]个
    private String[] initMap = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};


    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new ArrayList<>();
        List<String> results = new ArrayList<>();

        backtrack(digits, results, "", 0);
        return results;
    }

    private void backtrack(String digits, List<String> results, String tmp, Integer digIdx) {
        if (digIdx == digits.length()) {
            results.add(tmp);
            return;
        }

        int digit = digits.charAt(digIdx++) - '0';

        for (char letter : initMap[digit].toCharArray()) {
            backtrack(digits, results, tmp + Character.toString(letter), digIdx);
        }
    }

    public static void main(String[] args) {
        LetterCombinationsofaPhoneNumber t = new LetterCombinationsofaPhoneNumber();
        String dig = "23";

        System.out.println(t.letterCombinations(dig));
    }
}
