import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    private Character[] parenthese = {'(', ')'};

    public List<String> generateParenthesis(int n) {
        if (n <= 0) return new ArrayList<>();

        List<String> results = new ArrayList<>();
        backtrack(n * 2, results, "", 0);

        return results;
    }

    public void backtrack(int maxlen, List<String> results, String tmp, int flag) {
        if (tmp.length() == maxlen) {
            results.add(tmp);
            return;
        }


        if (flag < maxlen / 2) {
            backtrack(maxlen, results, tmp + '(', flag+1);
        }

        if (flag > 0 && tmp.length() < 2 * flag) {
            backtrack(maxlen, results, tmp + ')', flag);

        }
    }

    public static void main(String[] args) {
        GenerateParentheses t = new GenerateParentheses();
        int n = 3;
        System.out.println(t.generateParenthesis(n));
    }
}
