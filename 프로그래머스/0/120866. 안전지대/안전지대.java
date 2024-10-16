import java.util.*;

class Solution {
    public int solution(int[][] board) {
        int boardLen = board.length;
        int boardSize = (int)Math.pow(boardLen, 2);
        int dangerZoneSize = 0;

        for (int row = 0; row < boardLen; row++) {
            for (int col = 0; col < boardLen; col++) {
                if (board[row][col] == 1) {
                    dangerZoneSize++;
                    // 좌우상하
                    if (row - 1 >= 0 && board[row - 1][col] != 1 && board[row - 1][col] != 2) {
                        dangerZoneSize++;
                        board[row - 1][col] = 2;
                    }
                    if (row + 1 < boardLen && board[row + 1][col] != 1 && board[row + 1][col] != 2) {
                        dangerZoneSize++;
                        board[row + 1][col] = 2;
                    }
                    if (col + 1 < boardLen && board[row][col + 1] != 1 && board[row][col + 1] != 2) {
                        dangerZoneSize++;
                        board[row][col + 1] = 2;
                    }
                    if (col - 1 >= 0 && board[row][col - 1] != 1 && board[row][col - 1] != 2) {
                        dangerZoneSize++;
                        board[row][col - 1] = 2;
                    }

                    // 대각선 좌상 우상 좌하 우하
                    if (row - 1 >= 0 && col - 1 >= 0 && board[row - 1][col - 1] != 1 && board[row - 1][col - 1] != 2) {
                        dangerZoneSize++;
                        board[row - 1][col - 1] = 2;
                    }
                    if (row + 1 < boardLen && col - 1 >= 0 && board[row + 1][col - 1] != 1 && board[row + 1][col - 1] != 2) {
                        dangerZoneSize++;
                        board[row + 1][col - 1] = 2;
                    }
                    if (row - 1 >= 0 && col + 1 < boardLen && board[row - 1][col + 1] != 1 && board[row - 1][col + 1] != 2) {
                        dangerZoneSize++;
                        board[row - 1][col + 1] = 2;
                    }
                    if (row + 1 < boardLen && col + 1 < boardLen && board[row + 1][col + 1] != 1 && board[row + 1][col + 1] != 2) {
                        dangerZoneSize++;
                        board[row + 1][col + 1] = 2;
                    }
                }
            }
        }

        return boardSize - dangerZoneSize;
    }
}
