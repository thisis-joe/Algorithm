import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        
        Map<Character,Integer> score = new HashMap<>(); // -> 이걸 배열로하고싶은데 
        score.put('R',0); score.put('T',0);
        score.put('C',0); score.put('F',0);
        score.put('J',0); score.put('M',0);
        score.put('A',0); score.put('N',0);
        
        int[] choiceScore = new int[]{3,2,1,0,1,2,3};
        for(int i = 0 ; i < survey.length; i++){
            if(choices[i] == 4) continue;
            else{
                int idx = choices[i] < 4 ? 0 : 1;
                score.put(survey[i].charAt(idx),
                            score.get(survey[i].charAt(idx)) + choiceScore[choices[i]-1]);
            }
        }
        
        char[] answer = new char[4];
        answer[0] = score.get('R') >= score.get('T') ? 'R' : 'T';
        answer[1] = score.get('C') >= score.get('F') ? 'C' : 'F';
        answer[2] = score.get('J') >= score.get('M') ? 'J' : 'M';
        answer[3] = score.get('A') >= score.get('N') ? 'A' : 'N';
    
        return new String(answer);
        
    }
}