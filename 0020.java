import java.util.*;

class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        if (n % 2 != 0)
            return false;
        Stack<Character> bracketStack = new Stack<Character>();
        Map<Character, Character> bracketMap = new HashMap<>();
        bracketMap.put('(', ')');
        bracketMap.put('{', '}');
        bracketMap.put('[', ']');

        for (char c : s.toCharArray()) {
            if (bracketMap.containsKey(c)) {
                bracketStack.add(bracketMap.get(c));
            } else if (bracketStack.isEmpty() || (!bracketStack.isEmpty() && bracketStack.pop() != c)) {
                return false;
            }
        }

        return bracketStack.isEmpty();
    }
}