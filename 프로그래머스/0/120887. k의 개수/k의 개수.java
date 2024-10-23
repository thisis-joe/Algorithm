import java.util.*;
class Solution {
    public int solution(int i, int j, int k) {
        int sum = 0;
        for(int num=i;num<=j;num++){
            List<String> numList = 
                new ArrayList<>(Arrays.asList((num+"").split("")));
            
            sum += Collections.frequency(numList,k+"");
        }
        return sum;
    }
}