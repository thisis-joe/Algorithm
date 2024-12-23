import java.util.*;

class Solution {
    public int solution(String s) {
        String[] sArr = s.split("");
        Stack<String> stk = new Stack<>();

        for (String ch : sArr) {
            if (!stk.isEmpty() && stk.peek().equals(ch)) {
                stk.pop();
            } else {
                stk.push(ch);
            }
        }

        return stk.isEmpty() ? 1 : 0;
    }
}