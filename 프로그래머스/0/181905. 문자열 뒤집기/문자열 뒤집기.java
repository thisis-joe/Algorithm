import java.util.*;

//StringBuilder에서 substring을 수행해도 반환은 String이다. 

class Solution {
    public String solution(String my_string, int s, int e) {
        StringBuilder sb = new StringBuilder(my_string);
        StringBuilder answer = new StringBuilder();
        answer.append(sb.substring(0,s)).append(new StringBuilder(sb.substring(s,e+1)).reverse()).append(sb.substring(e+1,sb.length()));
        return answer.toString();
    }
}