import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        
        int[] answer = new int[targets.length];
        
        for(int i = 0 ; i < targets.length ; i++){
            int countTarget = 0;
            
            
            //target 1개의 문자 각각에 대해 순회하며 카운트
            for(char c : targets[i].toCharArray()){    
                boolean isPossible = false;    
                //존재 
                int min = Integer.MAX_VALUE;
                for(int j = 0 ; j < keymap.length ; j++){
                    if(keymap[j].contains(c+"")){
                        min = Math.min(min,keymap[j].indexOf(c)+1); //중복이 있어도 가장 왼쪽의 인덱스를 가져올 것임.
                        isPossible = true; //한번이라도 keymap[i]에 target의 문자가 존재하면 true
                    }
                }
                answer[i] += min;
                //존재 X
                if(!isPossible){
                    answer[i] = -1;
                    break;
                }
            }
            

            
        }
        
        return answer;
        
    }
}