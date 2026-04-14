

import java.util.*;
import java.io.*;

public class Solution {
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
				dp[r][c] = input != 0 ? 1 : 0; 
				c++;
			}
			
			//플로이드-워셜 dp 2차원 구현부
			for(int k = 0 ; k < N ; k++) {
				for(int r = 0 ; r < N ; r++) {
					for(int c = 0 ; c < N ; c++) {
						if(r==c) continue;
						if(dp[r][k] > 0 && dp[k][c] > 0) { // 경유지 통해서 가는 경로가 존재
							if(dp[r][c] == 0) dp[r][c] = dp[r][k] + dp[k][c]; //직접경로 없으면 경유지 통하게 해줌
							else if(dp[r][c] > 1) dp[r][c] = Math.min(dp[r][c], dp[r][k] + dp[k][c]); //경유지 통해서 가는 길만 있으면 최신화 할건지 결정
						}
					}
				}
			}
			
			//최소값 갱신
			int cc[] = new int[N];
			for(int r = 0 ; r < N ; r++) {	
				cc[r] = Arrays.stream(dp[r]).sum();
			}
			
			sb.append(Arrays.stream(cc).min().orElse(-88)+"\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
