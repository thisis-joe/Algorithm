import java.util.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
        StringBuilder sb = new StringBuilder();
        Map<Character,Integer> map = new HashMap<>();
        map.put('R',0); map.put('T',0);
        map.put('C',0); map.put('F',0);
        map.put('J',0); map.put('M',0);
        map.put('A',0); map.put('N',0);
        
        for(int i=0;i<survey.length;i++){
            char left = survey[i].charAt(0);
            char right = survey[i].charAt(1);
            int leftScore = 4-choices[i];
            int rightScore = choices[i]-4;
                
            if(choices[i]==4) {
                continue;
            }
            else if(choices[i]<4){
                map.put(left, map.get(left)+leftScore);
            }
            else{
                map.put(right, map.get(right)+rightScore);   
            }
        }
        
        sb.append( map.get('R') >= map.get('T') ? 'R' : 'T' );
        sb.append( map.get('C') >= map.get('F') ? 'C' : 'F' );
        sb.append( map.get('J') >= map.get('M') ? 'J' : 'M' );
        sb.append( map.get('A') >= map.get('N') ? 'A' : 'N' );
        
        
        return sb.toString();
    }   
}