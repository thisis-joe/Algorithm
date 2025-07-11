import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        
        int idxF = 0;
        int idxB = people.length-1;
        int left = people.length;
        int count = 0;
        
        Arrays.sort(people);
        
        while(left > 0){
            if(idxB -1 < 0) {
                count++;
                break;
            }
            //2명경우 (1)
            if(people[idxF] + people[idxB] <= limit) {
                count++;
                left-=2;
                idxB--;
                idxF++;
            }
            else{
                count++;
                left--;
                idxB--;
            }
        }
        
        return count;
    }
}
