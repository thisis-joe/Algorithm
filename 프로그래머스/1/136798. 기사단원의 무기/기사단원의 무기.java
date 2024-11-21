import java.util.*;
class Solution {
    public int solution(int number, int limit, int power) {
        int totalweight = 0;
        for(int i=1;i<=number;i++){
            //약수의 개수 계산 및 limit 이하로만 저장
            int weapon = 0;
            for(int j=1;j<=i/2.0;j++){ //약수 최댓값은 자신의 절반을 넘지 않음. i==2인 경우를 위해 /2.0
                if(i%j==0) weapon++;
            }
            weapon++;
            totalweight += weapon > limit ? power : weapon;
        }
        return totalweight;
    }
}