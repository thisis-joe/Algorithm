import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        Map<String, Integer> people = new HashMap<>();
        for(String p : participant){
            people.put(p,people.getOrDefault(p,0)+1);
        }
        for(String c : completion){ 
            if(people.get(c) != 0){ 
                people.put(c,people.get(c)-1);
            }
        }
        for(String key : people.keySet()){
            if(people.get(key) !=0){
                return key;
            }
        }
        return "";
    }
}