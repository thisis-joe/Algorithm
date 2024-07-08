import java.util.*;

class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = new int[2];
        int bunmo = denom1 * denom2; 
        int bunja = numer1 * denom2 + numer2 * denom1;
        int gcd = gcd(bunja,bunmo);
        answer[0]=bunja/gcd;
        answer[1]=bunmo/gcd;
        return answer;
    }
    // 최대 공약수(GCD) 계산을 위한 유클리드 호제법
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
