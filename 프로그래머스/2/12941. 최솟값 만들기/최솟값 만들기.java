import java.util.Arrays;

class Solution {
    public int solution(int[] A, int[] B) {
        // 1. 배열 A는 오름차순 정렬
        Arrays.sort(A);
        // 2. 배열 B는 내림차순 정렬
        Arrays.sort(B);
        for (int i = 0, j = B.length - 1; i < j; i++, j--) {
            int temp = B[i];
            B[i] = B[j];
            B[j] = temp;
        }

        // 3. A와 B의 각각 대응되는 값을 곱하여 누적
        int answer = 0;
        for (int i = 0; i < A.length; i++) {
            answer += A[i] * B[i];
        }

        return answer;
    }
}