import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] Ti = new int[N+1];
        int[] Pi = new int[N+1];
        int[] dp = new int[N+2]; // N+1일까지 가능하게

        for (int i = 1; i <= N; i++) {
            Ti[i] = sc.nextInt();
            Pi[i] = sc.nextInt();
        }

        // 역순으로 진행
        for (int i = N; i >= 1; i--) {
            int endDay = i + Ti[i] - 1;
            if (endDay <= N) {
                dp[i] = Math.max(Pi[i] + dp[i + Ti[i]], dp[i + 1]); // 상담함 vs 안 함
            } else {
                dp[i] = dp[i + 1]; // 상담 못함
            }
        }

        System.out.println(dp[1]); // 1일부터 시작한 최대 이익
    }
}
