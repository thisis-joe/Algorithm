import java.util.*;

public class Main {
    static int N;
    static int[][] S;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        S = new int[N][N];
        visited = new boolean[N];

        // 능력치 입력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                S[i][j] = sc.nextInt();
            }
        }

        // 조합 생성 (DFS)
        dfs(0, 0);

        System.out.println(min);
    }

    // depth: 현재까지 선택한 인원 수
    // start: 조합 시작 인덱스
    static void dfs(int depth, int start) {
        if (depth == N / 2) {
            calculateDiff();
            return;
        }

        for (int i = start; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;       // 스타트 팀에 포함
                dfs(depth + 1, i + 1);   // 다음 사람 선택
                visited[i] = false;      // 백트래킹
            }
        }
    }

    static void calculateDiff() {
        int startSum = 0;
        int linkSum = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visited[i] && visited[j]) { // 둘 다 스타트 팀
                    startSum += S[i][j] + S[j][i];
                } else if (!visited[i] && !visited[j]) { // 둘 다 링크 팀
                    linkSum += S[i][j] + S[j][i];
                }
            }
        }

        int diff = Math.abs(startSum - linkSum);
        if (diff == 0) {
            System.out.println(0);  // 더 이상 볼 필요 없음
            System.exit(0);
        }

        min = Math.min(min, diff);
    }
}
