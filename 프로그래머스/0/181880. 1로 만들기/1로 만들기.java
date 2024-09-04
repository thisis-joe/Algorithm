class Solution {
    public int solution(int[] num_list) {
        int totalOperations = 0;  // 전체 연산 횟수를 저장할 변수

        // 각 숫자에 대해 1이 될 때까지 연산 수행
        for (int num : num_list) {
            int operations = 0; // 현재 숫자의 연산 횟수 저장
            while (num > 1) { // 숫자가 1보다 큰 동안 반복
                if (num % 2 == 0) {  // 짝수인 경우
                    num /= 2;
                } else {  // 홀수인 경우
                    num = (num - 1) / 2;
                }
                operations++;  // 연산 횟수 증가
            }
            totalOperations += operations;  // 전체 연산 횟수에 누적
        }

        return totalOperations;  // 전체 연산 횟수 반환
    }
}