import java.util.*;

class Solution {
    public String solution(String my_string, int m, int c) {

        StringBuilder result = new StringBuilder();

        // 문자열 my_string을 m 길이로 잘라서 세로로 c번째 열에 해당하는 문자들을 추출
        for (int i = c - 1; i < my_string.length(); i += m) {
            result.append(my_string.charAt(i));
        }

        return result.toString();
    }
}