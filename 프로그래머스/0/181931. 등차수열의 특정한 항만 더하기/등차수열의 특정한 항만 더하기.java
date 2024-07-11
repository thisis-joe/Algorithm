import java.util.*;

class Solution {
    public int solution(int a, int d, boolean[] included) {
        int[] intarr = new int[100]; //included의 최대개수로 생성
        intarr[0] = a;
        int answer = 0 ;
        
        for(int i=1;i<included.length;i++){
            intarr[i] = intarr[i-1] + d;
        }
        for(int i=0;i<included.length;i++){
            answer = included[i] == true ? answer + intarr[i] : answer;
        }
        
        return answer;
    }
}