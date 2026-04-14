
import java.util.*;
import java.io.*;

public class Solution{
	static final int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T ; tc++) {
			sb.append("#"+tc+" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			
			//플로이드-워셜 dp 2차원 선언 , 초기화
			int dp[][] = new int[N][N]; //dp : dist
			for(int i = 0; i < N ; i++) Arrays.fill(dp[i], -1); 
			
			for(int i = 0, r = 0, c = 0; i < N*N ; i++) {
				if(c>=N) {
					r++;
					c %= N;
				}
				int input = Integer.parseInt(st.nextToken());
				dp[r][c] = r==c ? 0 : input == 1 ? 1 : INF; 
				c++;
			}
			
			//플로이드-워셜 dp 2차원 구현부
			for(int k = 0 ; k < N ; k++) {
				for(int r = 0 ; r < N ; r++) {
					if(dp[r][k] == INF) continue;
					
					for(int c = 0 ; c < N ; c++) {
						if(dp[k][c] == INF || r==c) continue;
						dp[r][c] = Math.min(dp[r][c], dp[r][k] + dp[k][c]);
					}
				}
			}
			
			//최소값 갱신
			int answer = INF;
			for(int i = 0; i < N; i++) {
				int sum = 0;
				for(int j = 0; j < N; j++) {
					sum += dp[i][j];
				}
				answer = Math.min(answer, sum);
			}

			sb.append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
