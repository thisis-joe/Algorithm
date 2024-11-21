import java.util.*;
class Solution {
    public int solution(int k, int m, int[] score) {
        int benefit=0;
        Integer[] score_new = Arrays.stream(score).boxed().toArray(Integer[]::new);
        Arrays.sort(score_new,Collections.reverseOrder()); //내림차순 정렬
        
        for(int i=m-1;i<score.length-score.length%m;i+=m){ //마지막 1개만 본다.
            benefit += score_new[i] * m ; 
        }
        return benefit;
    }
}