public class Solution {
    int n, answer = 0;
    boolean[] col, d1, d2; // col[c], d1[r-c+n-1], d2[r+c]

    public int solution(int n) {
        this.n = n;
        col = new boolean[n];
        d1  = new boolean[2*n - 1];
        d2  = new boolean[2*n - 1];
        backtrack(0);
        return answer;
    }
    private void backtrack(int r) {
        if (r == n) { answer++; return; }
        for (int c = 0; c < n; c++) {
            int a = r - c + n - 1, b = r + c;
            if (col[c] || d1[a] || d2[b]) continue;
            col[c] = d1[a] = d2[b] = true;
            backtrack(r + 1);
            col[c] = d1[a] = d2[b] = false;
        }
    }
}
