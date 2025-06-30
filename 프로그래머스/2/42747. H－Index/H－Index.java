import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Integer[] citationsW = Arrays.stream(citations).boxed().toArray(Integer[]::new);
        Arrays.sort(citationsW,Collections.reverseOrder());
        
        // H-Index 찾기
        for (int i = 0; i < citationsW.length; i++) {
            if (citationsW[i] < i + 1) {
                return i;
            }
        }
        
        return citationsW.length;
    }
}