import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        
        int idxF = 0;
        int idxB = people.length -1;
        int boatCnt = 0;
        Arrays.sort(people);
        while(idxF <= idxB){
            if(people[idxF]+people[idxB]<=limit){
                boatCnt++;
                idxF++;
                idxB--;
            }
            else{
                boatCnt++;
                idxB--;
            }
        }
        
        return boatCnt;
        
    }
}