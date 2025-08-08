class Solution {
    public int solution(String name) {
        int len = name.length();
        int answer = 0;

        // 1. 상/하 이동 계산
        for (int i = 0; i < len; i++) {
            char c = name.charAt(i);
            answer += Math.min(c - 'A', 'Z' - c + 1);
        }

        // 2. 좌/우 이동 최적화
        int move = len - 1; // 그냥 오른쪽으로 쭉 가는 경우
        for (int i = 0; i < len; i++) {
            int next = i + 1;
            // 다음 문자가 'A'인 경우, 끝까지 연속된 A를 찾음
            while (next < len && name.charAt(next) == 'A') {
                next++;
            }
            // i에서 되돌아가서 뒤쪽 처리하는 경우와 비교
            move = Math.min(move, i * 2 + len - next);
            // 반대로 뒤에서 먼저 처리하고 오는 경우
            move = Math.min(move, (len - next) * 2 + i);
        }

        return answer + move;
    }
}
