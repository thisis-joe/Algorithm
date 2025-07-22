import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int[][] server = new int[2][24];
        Arrays.fill(server[0], 0); // 현재 서버 대수
        Arrays.fill(server[1], 0); // 누적 증설 횟수

        for (int i = 0; i < 24; i++) {
            int nowNeed = players[i] / m; // 현재 필요한 서버 수
            int nowCom = server[0][i];    // 현재 가동 중인 서버 수

            if (nowNeed > nowCom) { // 증설이 필요한 경우
                int upgrade = nowNeed - nowCom;
                server[1][i] = (i == 0) ? nowNeed : server[1][i - 1] + upgrade;

                // 증설된 서버를 k시간 동안 유지
                for (int j = i; j < i + k; j++) {
                    if (j <= 23) {
                        server[0][j] += upgrade;
                    } else {
                        break;
                    }
                }
            } else { // 증설이 필요 없는 경우
                server[1][i] = (i == 0) ? nowNeed : server[1][i - 1];
            }
        }

        return server[1][23]; // 마지막 시간(23시)까지의 누적 증설 횟수 반환
    }
}