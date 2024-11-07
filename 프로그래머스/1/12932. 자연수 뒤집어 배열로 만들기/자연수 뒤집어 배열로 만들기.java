import java.util.*;
class Solution {
    public int[] solution(long n) {
        List<Integer> intList = new ArrayList<>();
        while(n>0){
            int k = Long.valueOf(n%10).intValue();
            intList.add(k);
            n/=10;
        }
        return intList.stream().mapToInt(i->i).toArray();
        
    }
}