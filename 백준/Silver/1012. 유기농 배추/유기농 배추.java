import java.util.*;

public class Main {
    static int M, N, K;
    static boolean[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스 수

        while (T-- > 0) {
            M = sc.nextInt(); // 가로
            N = sc.nextInt(); // 세로
            K = sc.nextInt(); // 배추 개수

            map = new boolean[N][M];
            visited = new boolean[N][M];

            for (int i = 0; i < K; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                map[y][x] = true;
            }

            int count = 0;
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    if (map[y][x] && !visited[y][x]) {
                        dfs(x, y);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }

    static void dfs(int x, int y) {
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
                if (map[ny][nx] && !visited[ny][nx]) {
                    dfs(nx, ny);
                }
            }
        }
    }
}
