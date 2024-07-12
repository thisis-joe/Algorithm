import java.util.*;
//Stringbuilder의 replace를 알고 있는가
class Solution {
    public String solution(String my_string, int[][] queries) {
        StringBuilder sb = new StringBuilder();
        sb.append(my_string);
        
        for(int[] query : queries){
            // 부분 문자열 추출 후 뒤집기
            StringBuilder reversedPart = new StringBuilder(sb.substring(query[0], query[1] + 1)).reverse();
            sb.replace(query[0],query[1]+1,reversedPart.toString());

        }
        return sb.toString();
    }
}
