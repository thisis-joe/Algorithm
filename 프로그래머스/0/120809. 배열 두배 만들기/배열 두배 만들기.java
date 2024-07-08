import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = numbers;
        System.out.println(Arrays.toString(answer)); //자바 배열 출력
        //for-each문
        int i=0;
        for(int num : answer){
            answer[i]=num*2;
            i++;
        }
        return answer;
    }
}
