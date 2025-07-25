import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();  // 수빈이 위치
        int K = sc.nextInt();  // 동생 위치

        final int MAX = 200001;
        boolean[] visited = new boolean[MAX];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(N);
        visited[N] = true;

        int time = 0;  // BFS 탐색 레벨 = 시간

        while (!queue.isEmpty()) {
            int size = queue.size();  // 현재 레벨(시간)에 해당하는 노드 수

            for (int i = 0; i < size; i++) {
                int current = queue.poll();

                if (current == K) {
                    System.out.println(time);
                    return;
                }

                int[] next = {current - 1, current + 1, current * 2};
                for (int pos : next) {
                    if (pos >= 0 && pos < MAX && !visited[pos]) {
                        visited[pos] = true;
                        queue.add(pos);
                    }
                }
            }

            time++;  // 한 단계(1초) 지남
        }
    }
}
