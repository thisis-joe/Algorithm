import java.util.*;

class Solution {
    public String solution(String my_string, int m, int c) {
        StringBuilder sb = new StringBuilder();
        int len = my_string.length();
        int numSegments = (len % m == 0) ? len / m : len / m + 1;
        String[] strArr = new String[numSegments]; // 정확한 세그먼트 개수 계산

        int s = 0;
        int e = m;
        
        // 세그먼트 생성
        for (int i = 0; i < numSegments; i++) {
            if (e <= len) {
                strArr[i] = my_string.substring(s, e);
            } else {
                strArr[i] = my_string.substring(s); // 마지막 세그먼트는 남은 문자열 전체
            }
            s += m;
            e += m;
        }

        // 각 세그먼트에서 c번째 문자 추출
        for (String str : strArr) {
            if (str.length() >= c) {
                sb.append(str.charAt(c - 1)); // c번째 문자는 인덱스 c-1
            }
        }
        return sb.toString();
    }
}