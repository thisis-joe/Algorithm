import java.util.*;

class Solution {
    List<String> dictionary = new ArrayList<>();
    String[] vowels = {"A", "E", "I", "O", "U"};
    
    public int solution(String word) {
        dfs("",0);
        Collections.sort(dictionary);
        return dictionary.indexOf(word)+1;
    }

    void dfs(String newWord, int depth){
        if(depth > 5){
            return;
        }
        if(!newWord.equals("")){
            dictionary.add(newWord);
        }
        
        for(String v : vowels){
            dfs(newWord + v, depth + 1);   
        }
        
    }
}