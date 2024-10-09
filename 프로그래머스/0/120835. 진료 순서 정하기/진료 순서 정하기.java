import java.util.*;

class Solution {
    public int[] solution(int[] emergency) {
        int[] answer = new int[emergency.length];
        
        for(int i=0;i<emergency.length;i++){
            int k = emergency[i];
            answer[i]++;
            for(int j=0;j<emergency.length;j++){
                if(i==j) continue;
                if(k<emergency[j]) answer[i]++;
            }
        }
        return answer;
        
    }
}