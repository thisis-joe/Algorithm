import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] guy1 = {1, 2, 3, 4, 5};
        int[] guy2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] guy3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] guysCnt = new int[3];
        
        for(int i=0; i<answers.length; i++){
            if(answers[i]==guy1[i%5]) guysCnt[0]++;
            if(answers[i]==guy2[i%8]) guysCnt[1]++;
            if(answers[i]==guy3[i%10]) guysCnt[2]++;
        }
        
        //여기서부터 생각을 못했음. 나는 if=else 쳐서 모든 경우의 수를 고려하려고 했는데, 너무 길어져서 이건 아니다 싶긴했다만. 이런 방법이!
        
        //max를 계속 겹쳐가면서 배열의 최대 값을 찾을 수 있다.
        int maxScore = Math.max(guysCnt[0],Math.max(guysCnt[1],guysCnt[2]));
        List<Integer> intList = new ArrayList<>();
        
        for(int i=0;i<guysCnt.length;i++){
            if(guysCnt[i]==maxScore){
                intList.add(i+1);               
            }
        }
        
        return intList.stream().mapToInt(i->i).toArray();
        
    }
}