import java.util.*;
class Solution {
    public int solution(int[] sides) {
        int side1 = Math.max(sides[0],sides[1]);
        int side2 = Math.min(sides[0],sides[1]);
        int side3 = side1;
        int cnt = 0;
        
        //side1 이 가장 길 때
        for(int i=1; i<side1; i++){
            if(i+side2>side1) cnt++;
        }
        //side3 가 가장 길 때
        while(side1+side2>side3){
            cnt++;
            side3++;
        }
        return cnt;
    }
}