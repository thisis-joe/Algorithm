import java.util.*;

public class Main {
    static int N;
    static int[] T, P;
    static int maxProfit = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        T = new int[N + 1];
        P = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            T[i] = sc.nextInt();
            P[i] = sc.nextInt();
        }

        dfs(1, 0);

        System.out.println(maxProfit);
    }

    static void dfs(int day, int sum) {
        // 퇴사일을 넘긴 경우 종료
        if (day > N + 1) return;

        // 정확히 퇴사일 도달 시 최대 이익 갱신
        if (day == N + 1) {
            maxProfit = Math.max(maxProfit, sum);
            return;
        }

        // 1. 현재 상담을 한다면 (Ti[day]일 걸림)
        if (day + T[day] <= N + 1) {
            dfs(day + T[day], sum + P[day]);
        }

        // 2. 현재 상담을 안 하고 다음 날로 넘어감
        dfs(day + 1, sum);
    }
}
