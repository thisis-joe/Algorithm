import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int min, N, S[][];
    static boolean[] isSelected; //A, B 구분 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; tc++) {
        	min = Integer.MAX_VALUE;
            N = Integer.parseInt(br.readLine());
            S = new int[N][N];
            isSelected = new boolean[N]; // 선택 여부로 A/B 구분

            for (int r = 0; r < N; r++) {
                StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
                for (int c = 0; c < N; c++) {
                    S[r][c] = Integer.parseInt(stk.nextToken());
                }
            }

            generateCombination(0, 0);

            System.out.println("#" + tc + " " + min);
        }
    }
    
    //조합 및 계산
    static void generateCombination(int cnt, int start) {
        if (cnt == N / 2) {
            calculateDifference(); //계산
            return;
        }

        for (int i = start; i < N; i++) {
            isSelected[i] = true; //A 선택
            generateCombination(cnt + 1, i + 1); //A 다음 선택
            isSelected[i] = false; //A 선택 해제
        }
    }
    
    //계산
    static void calculateDifference() {
        int scoreA = 0;
        int scoreB = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) continue; // 같은 재료 제외
                if (isSelected[i] && isSelected[j]) { //둘다 A
                    scoreA += S[i][j];
                }
                else if (!isSelected[i] && !isSelected[j]) {
                    scoreB += S[i][j];
                }
            }
        }

        // 최솟값 갱신
        min = Math.min(min, Math.abs(scoreA - scoreB));
    }
}
