import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int n = data.length;

        // 1) 버블 정렬: (col-1) 오름차순, 같으면 data[][0] 내림차순
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                int c1 = data[j][col - 1];     // col은 1-based → 0-based로
                int c2 = data[j + 1][col - 1];
                if (c1 > c2) {
                    swapRow(data, j, j + 1);
                } else if (c1 == c2) {
                    // 기본키(첫 컬럼) 내림차순
                    if (data[j][0] < data[j + 1][0]) {
                        swapRow(data, j, j + 1);
                    }
                }
            }
        }

        // 2) S_i 계산 + XOR 누적 (i는 정렬 후 1-based)
        int hash = 0;
        for (int i = row_begin; i <= row_end; i++) {
            int[] row = data[i - 1]; // i번째(1-based) → index i-1
            int s = 0;
            for (int v : row) s += v % i;
            hash ^= s; // 비트 단위 XOR (정수끼리)
        }
        return hash;
    }

    private void swapRow(int[][] a, int i, int j) {
        int[] tmp = a[i]; a[i] = a[j]; a[j] = tmp; // 레퍼런스만 교환
    }
}
