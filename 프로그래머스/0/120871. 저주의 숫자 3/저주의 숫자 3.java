import java.util.*;
class Solution {
    public int solution(int n) {
        List<Integer> no3List = new ArrayList<>();
        
        for(int i=0; no3List.size()< n ;i++){
            if( i%3==0 || String.valueOf(i).contains("3")) continue;
            else no3List.add(i);
        }
        int[] no3Arr = no3List.stream().mapToInt(i->i).toArray();
        for(int num : no3Arr) System.out.print(num +" ");
        return no3Arr[n-1];
    }
}