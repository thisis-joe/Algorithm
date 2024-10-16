class Solution {
    public int solution(int[][] board) {
        int n = board.length;
        boolean[][] dangerZone = new boolean[n][n];  // 위험 지역을 저장할 배열
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};  // 8방향 이동 (좌상, 상, 우상, 좌, 우, 좌하, 하, 우하)
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (board[row][col] == 1) {
                    for (int dir = 0; dir < 8; dir++) {
                        int newRow = row + dx[dir];
                        int newCol = col + dy[dir];

                        if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n) {
                            dangerZone[newRow][newCol] = true;
                        }
                    }
                    dangerZone[row][col] = true;
                }
            }
        }

        int safeCount = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (!dangerZone[row][col]) {
                    safeCount++;
                }
            }
        }

        return safeCount;
    }
}
