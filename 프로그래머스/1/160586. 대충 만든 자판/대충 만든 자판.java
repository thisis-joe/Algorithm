import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        List<Integer> intList = new ArrayList<>();
        for(String target : targets){
            int cntSum = 0;
            boolean canType = true;
            for(int i=0;i<target.length();i++){  
                int min = Integer.MAX_VALUE; 
                for(String eachKM : keymap){
                    for(int j=0;j<eachKM.length();j++){
                        if(eachKM.charAt(j)==target.charAt(i)){ 
                            if(min>j) min=j+1; 
                            break; 
                        }
                    }
                }
                if (min == Integer.MAX_VALUE) { // 해당 문자가 keymap에 없는 경우
                    canType = false;
                    break;
                } else {
                    cntSum += min;
                }
            }
            // target을 완성할 수 없는 경우 -1 추가
            intList.add(canType ? cntSum : -1);
        }
        
        return intList.stream().mapToInt(i->i).toArray();
    }
}