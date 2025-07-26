import java.util.*;

public class Main {
    static final int MAX = 100001;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();  // 수빈 위치
        int K = sc.nextInt();  // 동생 위치

        int[] time = new int[MAX]; // 각 위치에 도달한 시간
        int[] count = new int[MAX]; // 해당 위치까지 최소 시간으로 도달하는 방법 수

        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        time[N] = 1; // 0초 대신 1로 시작 (0을 구분 값으로 쓰기 위함)
        count[N] = 1;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int next : new int[]{cur - 1, cur + 1, cur * 2}) {
                if (next < 0 || next >= MAX) continue;

                // 아직 방문하지 않은 곳
                if (time[next] == 0) {
                    time[next] = time[cur] + 1;
                    count[next] = count[cur];
                    queue.add(next);
                }
                // 같은 시간에 도달했다면 → 방법의 수 누적
                else if (time[next] == time[cur] + 1) {
                    count[next] += count[cur];
                }
            }
        }

        System.out.println(time[K] - 1); // 실제 시간은 1 빼기
        System.out.println(count[K]);
    }
}
