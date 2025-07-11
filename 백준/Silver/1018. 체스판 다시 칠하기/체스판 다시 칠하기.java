import java.util.*;

public class Main {
    static char[][] board;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        board = new char[N][M];
        int min = Integer.MAX_VALUE;

        // 입력
        for (int i = 0; i < N; i++) {
            board[i] = sc.next().toCharArray();
        }

        // 가능한 8x8 시작점 탐색
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                min = Math.min(min, coloring(i, j));
            }
        }

        System.out.println(min);
    }

    // (x, y)를 시작점으로 하는 8x8 보드의 재칠 횟수 계산
    public static int coloring(int x, int y) {
        int countW = 0; // 좌상단이 W인 경우
        int countB = 0; // 좌상단이 B인 경우

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char current = board[x + i][y + j];

                // (i+j)가 짝수면 시작 색, 홀수면 반대 색이어야 함
                if ((i + j) % 2 == 0) {
                    if (current != 'W') countW++; // W로 시작할 경우 틀린 칸
                    if (current != 'B') countB++; // B로 시작할 경우 틀린 칸
                } else {
                    if (current != 'B') countW++;
                    if (current != 'W') countB++;
                }
            }
        }

        return Math.min(countW, countB);
    }
}