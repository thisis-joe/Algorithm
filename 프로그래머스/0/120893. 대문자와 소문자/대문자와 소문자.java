import java.util.*;
class Solution {
    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder();
        for(char c : my_string.toCharArray()){
            if(c >='a' && c<= 'z'){
                sb.append(Character.toUpperCase(c));
            }else{
                sb.append(Character.toLowerCase(c));
            }
        }
        return sb.toString();
    }
}