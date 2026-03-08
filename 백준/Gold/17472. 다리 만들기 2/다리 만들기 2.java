import java.util.*;
import java.io.*;

public class Main {
    static int N, M, islandCnt = 0;
    static int[][] map;
    static boolean[][] visited;
    static int[] parent;
    static List<int[]> edges = new ArrayList<>(); // {cost, from, to}

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 1단계: BFS로 섬 번호 부여
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    islandCnt++;
                    bfsIsland(i, j, islandCnt);
                }
            }
        }

        // 2단계: 각 육지 칸에서 4방향으로 다리 탐색
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0) {
                    buildBridge(i, j);
                }
            }
        }

        // 3단계: 크루스칼 MST
        parent = new int[islandCnt + 1];
        for (int i = 1; i <= islandCnt; i++) parent[i] = i;

        edges.sort((a, b) -> a[0] - b[0]);

        int totalCost = 0;
        int connectedEdges = 0;

        for (int[] edge : edges) {
            int cost = edge[0], from = edge[1], to = edge[2];
            if (find(from) != find(to)) {
                union(from, to);
                totalCost += cost;
                connectedEdges++;
                if (connectedEdges == islandCnt - 1) break;
            }
        }

        // 모든 섬이 연결되었는지 확인
        if (connectedEdges == islandCnt - 1) {
            System.out.println(totalCost);
        } else {
            System.out.println(-1);
        }
    }

    // BFS: 섬에 번호 부여
    static void bfsIsland(int r, int c, int num) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});
        visited[r][c] = true;
        map[r][c] = num;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + dx[d];
                int nc = cur[1] + dy[d];
                if (nr >= 0 && nr < N && nc >= 0 && nc < M
                        && map[nr][nc] == 1 && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    map[nr][nc] = num;
                    queue.add(new int[]{nr, nc});
                }
            }
        }
    }

    // 한 방향으로만 직선 탐색하여 다리 후보 생성
    static void buildBridge(int r, int c) {
        int islandNum = map[r][c];

        for (int d = 0; d < 4; d++) {
            int nr = r + dx[d];
            int nc = c + dy[d];
            int length = 0;

            // 바다 위를 직선으로 이동
            while (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 0) {
                nr += dx[d];
                nc += dy[d];
                length++;
            }

            // 범위 내이고, 다른 섬에 도달하고, 길이 2 이상인 경우만 유효
            if (nr >= 0 && nr < N && nc >= 0 && nc < M
                    && map[nr][nc] != islandNum && length >= 2) {
                edges.add(new int[]{length, islandNum, map[nr][nc]});
            }
        }
    }

    static int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a < b) parent[b] = a;
        else parent[a] = b;
    }
}