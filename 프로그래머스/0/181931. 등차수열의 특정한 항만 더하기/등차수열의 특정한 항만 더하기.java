import java.util.*;

class Solution {
    public int solution(int a, int d, boolean[] included) {
        int sum=0;
        int current=0;
        for(int i=0;i<included.length;i++){
            current = a+i*d;
            if(included[i]) sum+=current;
        }
        
        return sum;
    }
}