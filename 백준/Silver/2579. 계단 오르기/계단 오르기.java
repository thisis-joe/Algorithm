import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  // 계단 개수

        int[] score = new int[n + 1]; // 각 계단의 점수 (1-indexed)
        int[] dp = new int[n + 1];    // dp[i]: i번째 계단까지의 최대 점수

        for (int i = 1; i <= n; i++) {
            score[i] = sc.nextInt();  // 각 계단 점수 입력
        }

        // 초기 조건 설정
        dp[1] = score[1];
        if (n >= 2) dp[2] = score[1] + score[2];
        if (n >= 3) dp[3] = Math.max(score[1] + score[3], score[2] + score[3]);

        // 점화식에 따라 dp 채우기
        for (int i = 4; i <= n; i++) {
            dp[i] = Math.max(
                dp[i - 2] + score[i],                    // i-2 → i
                dp[i - 3] + score[i - 1] + score[i]      // i-3 → i-1 → i
            );
        }

        // 마지막 계단은 반드시 밟아야 하므로 dp[n]이 정답
        System.out.println(dp[n]);
    }
}
