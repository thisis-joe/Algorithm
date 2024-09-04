import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int[] temparr = Arrays.copyOf(arr, arr.length); // arr의 복사본 생성
        int len = arr.length;
        int count = 0; // 반복 횟수 카운트

        // 무한 루프를 사용하지 않고 배열이 안정될 때까지 반복
        while (true) {
            boolean flag = true; // 배열 변경 여부 확인 플래그
            int[] previousArr = Arrays.copyOf(temparr, len); // 이전 상태를 저장

            // 배열 변경 로직
            for (int i = 0; i < len; i++) {
                if (temparr[i] >= 50 && temparr[i] % 2 == 0) {
                    temparr[i] /= 2;
                } else if (temparr[i] < 50 && temparr[i] % 2 != 0) {
                    temparr[i] = temparr[i] * 2 + 1;
                }

                // 변경된 값과 이전 상태의 값이 다른 경우 플래그를 false로 설정
                if (temparr[i] != previousArr[i]) {
                    flag = false;
                }
            }

            count++;

            // 배열이 더 이상 변하지 않으면 반복 횟수 반환
            if (flag) {
                return count - 1; // flag가 true일 때 count가 1 더 증가하므로 1을 빼줌
            }
        }
    }
}