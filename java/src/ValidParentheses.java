import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {
    private HashMap<Character, Character> map = new HashMap<>(3);

    {
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (!map.containsKey(ch)) {
                stack.push(ch);
            } else {
                if (stack.isEmpty() || stack.pop() != map.get(ch)) return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses t = new ValidParentheses();
        System.out.println(t.isValid("([)"));
        System.out.println(t.isValid("()[)]{}"));
        System.out.println(t.isValid("(]"));
        System.out.println(t.isValid("([)]"));
        System.out.println(t.isValid("([])"));
    }
}
