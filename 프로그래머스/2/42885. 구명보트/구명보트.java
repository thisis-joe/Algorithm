import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        /***
        * 한번에 최대 2명
        * 무게제한 40~limit, 최대 240
        * 모든 사람 구출가능한 구명보트 최소 개수?
        */
        
        int idxF = 0;
        int idxB = people.length-1;
        int left = people.length;
        int count = 0;
        
        Arrays.sort(people);
        
        while(idxF <= idxB){
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