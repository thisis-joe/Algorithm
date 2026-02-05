import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    static final int CARD_COUNT = 9;
    static final int TOTAL_SCORE = 171;
    static final int WIN_THRESHOLD = 85;
    
    static int[] gyuCards = new int[CARD_COUNT];
    static int[] ienCards = new int[CARD_COUNT];
    static int[] factorial = new int[CARD_COUNT + 1]; // 실행 시 계산
    static int[][] memo = new int[TOTAL_SCORE + 1][1 << CARD_COUNT];

    static void calculateFactorial() {
        factorial[0] = 1;
        for (int i = 1; i <= CARD_COUNT; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
    }

    static int solve(int round, int visitedMask, int gyuTotalScore, int ienTotalScore) {
        if (memo[ienTotalScore][visitedMask] != -1) {
            return memo[ienTotalScore][visitedMask];
        }

        if (ienTotalScore > WIN_THRESHOLD) {
            return memo[ienTotalScore][visitedMask] = factorial[CARD_COUNT - round];
        }
        if (gyuTotalScore > WIN_THRESHOLD) {
            return memo[ienTotalScore][visitedMask] = 0;
        }

        if (round >= CARD_COUNT) {
            return ienTotalScore > gyuTotalScore ? 1 : 0;
        }

        int winCount = 0;
        for (int i = 0; i < CARD_COUNT; i++) {
            if ((visitedMask & (1 << i)) == 0) {
                int currentRoundPoints = gyuCards[round] + ienCards[i];
                
                if (gyuCards[round] > ienCards[i]) {
                    winCount += solve(round + 1, visitedMask | (1 << i), gyuTotalScore + currentRoundPoints, ienTotalScore);
                } else {
                    winCount += solve(round + 1, visitedMask | (1 << i), gyuTotalScore, ienTotalScore + currentRoundPoints);
                }
            }
        }

        return memo[ienTotalScore][visitedMask] = winCount;
    }

    public static void main(String[] args) throws IOException {
        calculateFactorial(); // 팩토리얼 미리 계산
        
        int totalTestCases = readInt();
        StringBuilder resultBuilder = new StringBuilder();

        for (int tc = 1; tc <= totalTestCases; tc++) {
            boolean[] isGyuCard = new boolean[19];
            for (int i = 0; i < CARD_COUNT; i++) {
                gyuCards[i] = readInt();
                isGyuCard[gyuCards[i]] = true;
            }

            for (int i = 0; i < TOTAL_SCORE + 1; i++) {
                Arrays.fill(memo[i], -1);
            }

            int ienIdx = 0;
            for (int i = 1; i <= 18; i++) {
                if (!isGyuCard[i]) {
                    ienCards[ienIdx++] = i;
                }
            }

            int ienTotalWins = solve(0, 0, 0, 0);
            int gyuTotalWins = factorial[CARD_COUNT] - ienTotalWins;

            resultBuilder.append('#').append(tc)
                         .append(' ').append(gyuTotalWins)
                         .append(' ').append(ienTotalWins).append('\n');
        }

        System.out.print(resultBuilder);
    }

    static int readInt() throws IOException {
        int n = 0;
        int c = br.read();
        while (c <= 32) c = br.read();
        while ('0' <= c && c <= '9') {
            n = n * 10 + (c - '0');
            c = br.read();
        }
        return n;
    }
}