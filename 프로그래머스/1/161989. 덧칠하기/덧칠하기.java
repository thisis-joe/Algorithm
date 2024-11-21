class Solution {
    public int solution(int n, int m, int[] section) {
        int count = 0;         // 페인트 칠 횟수
        int lastPainted = 0;   // 마지막으로 페인트 칠된 구역

        for (int sec : section) {
            // 현재 구역이 마지막으로 칠해진 범위를 벗어나면 페인트 칠 필요
            if (sec > lastPainted) {
                count++;                 // 페인트 칠 횟수 증가
                lastPainted = sec + m - 1; // 롤러로 덮을 수 있는 범위 업데이트
            }
        }
        return count;
    }
}