import java.util.*;

class Solution {
    public int sumDivisor(int n){
        int sum=0;
        for(int i=1;i<=n/2;i++){
            if(n%i==0)sum+=i;
        }
        return sum+n;
    }
    public int solution(int n) {
        return sumDivisor(n);
    }
}