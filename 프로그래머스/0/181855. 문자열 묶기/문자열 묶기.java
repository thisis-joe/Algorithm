import java.util.*;
class Solution {
    public int solution(String[] strArr) {
        // 최대 길이를 알 수 있으므로 count 배열을 사용하여 각 길이에 대한 빈도를 기록
        int[] count = new int[100001];

        // 문자열 길이에 따라 count 배열에 빈도 기록
        for (String str : strArr) {
            int length = str.length();
            count[length]++;
        }

        // count 배열에서 가장 큰 값을 찾기
        int maxFrequency = 0;
        for (int freq : count) {
            if (freq > maxFrequency) {
                maxFrequency = freq;
            }
        }

        return maxFrequency;  // 가장 많이 나타난 문자열 길이의 빈도를 반환
    }
}
