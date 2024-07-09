//가장 큰값을 찾고, 반복문을 통해 count합니다. count용 배열을 만들자.
//최빈값이 2개 이상인 경우를 판단하기 위해. 
import java.util.*;
class Solution {
    public int solution(int[] array) {
        int[] count = new int[1000];
        int maxCount = 0; // 최대 빈도수를 저장할 변수
        int maxValue = -1; // 최빈값을 저장할 변수
        boolean isDuplicate = false; // 최빈값이 여러 개인지 여부를 저장할 변수

        // 배열 요소의 빈도수를 계산합니다.
        for (int num : array) {
            count[num]++;
            if (count[num] > maxCount) {
                maxCount = count[num];
                maxValue = num;
                isDuplicate = false;
            } else if (count[num] == maxCount) {
                isDuplicate = true;
            }
        }

        // 최빈값이 여러 개인 경우
        if (isDuplicate) {
            return -1;
        }
        
        return maxValue;
    }
}