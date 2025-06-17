import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        char[] res = s.toCharArray();
        String result = "";
        Set<Character> skips = new HashSet<>();
        
        // Skip 문자 Set으로 저장 (검색 속도 향상)
        for (char c : skip.toCharArray()) {
            skips.add(c);
        }
        
        // 각 문자 변환
        for (int i = 0; i < res.length; i++) {
            int steps = 0;
            char current = res[i];
            
            // Index만큼 이동 (skip 문자 제외)
            while (steps < index) {
                current++;
                if (current > 'z') current = 'a'; // Wrap-around 처리
                if (!skips.contains(current)) steps++;
            }
            
            res[i] = current; // 최종 변환된 문자 저장
        }
        
        // 배열을 문자열로 변환
        return new String(res);
    }
}