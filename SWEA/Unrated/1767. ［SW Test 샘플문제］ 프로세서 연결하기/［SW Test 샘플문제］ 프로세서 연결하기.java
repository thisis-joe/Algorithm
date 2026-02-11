import java.util.*;
import java.io.*;

public class Solution {
	static StringTokenizer st;
	static int N, NxN[][], currentCoreCnt, currentLength, maxCoreCnt, minLength;
	static List<Core> coreList;
	
	public static class Core{
		int r, c; 
		public Core(int r,int c){
			this.r=r;
			this.c=c;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int TC = Integer.parseInt(br.readLine());

	    for (int tc = 1; tc <= TC; tc++) {
	    	st = new StringTokenizer(br.readLine()," ");
	    	
	    	N = Integer.parseInt(st.nextToken());
	    	NxN = new int[N][N];
	    	
	    	currentCoreCnt = 0; //현재 판단한 코어의 개수
	    	maxCoreCnt = Integer.MIN_VALUE;
	    	coreList = new ArrayList<>();
	    	
	    	currentLength = 0;
	    	minLength = Integer.MAX_VALUE;
	    	
	    	for(int i = 0 ; i < N ; i++) {
	    		st = new StringTokenizer(br.readLine()," ");
	    		for(int j = 0 ; j < N ; j++) {
	    			NxN[i][j] = Integer.parseInt(st.nextToken());
	    			if(NxN[i][j] != 0 
	    					&& i != 0 	&& j != 0
	    					&& i != N-1 && j != N-1) coreList.add(new Core(i,j));
	    		}
	    	}
	    	
	    	dfs(0, coreList);
	    	
	    	sb.append('#').append(tc).append(' ').append(minLength).append('\n');
	    }
	    System.out.println(sb);
	    br.close();
	}
	
	/*
	 * @param cnt 깊이
	 * @param coreList 코어 좌표정보 
	 * */
	static void dfs(int cnt, List<Core> coreList) { 
		// 1. 기저 조건: 모든 코어를 검사했을 때
	    if (cnt == coreList.size()) {
	        if (currentCoreCnt > maxCoreCnt) {
	        	maxCoreCnt = currentCoreCnt;
	            minLength = currentLength;
	        } else if (currentCoreCnt == maxCoreCnt) {
	            minLength = Math.min(minLength, currentLength);
	        }
	        return;
	    }
	    
	    Core core = coreList.get(cnt);

	    // 2. 유도 파트: 4방향 탐색
	    for (int dir = 0; dir < 4; dir++) {
	        if (canIGoNow(core, dir)) {
	            // 전선 놓기 (상태 변경)
	            coloringNxN(core, dir); 
	            currentCoreCnt++;

	            dfs(cnt + 1, coreList); // 다음 코어로 이동

	            // 백트래킹 (상태 복구)
	            currentCoreCnt--;
	            deColoringNxN(core, dir); 
	        }
	    }
	    
	    // 이 코어를 연결하지 않고 다음 코어로 넘어가는 경우
	    dfs(cnt + 1, coreList);

	}

	
	/* 진행 가능 = 특정 방향에 코어가 존재하지 않음 
	 * @param dir  0:상 1:하 2:좌 3:우 4:불가능or방향없음
	 * */
	static boolean canIGoNow(Core core, int dir) {
		switch(dir) {
			case 0:  //상
				for(int r = core.r-1 ; r >= 0 ; r--) if(NxN[r][core.c] != 0) return false;
				break;
			case 1:  //하
				for(int r = core.r+1 ; r < N ; r++)  if(NxN[r][core.c] != 0) return false;
				break;
			case 2:  //좌
				for(int c = core.c-1 ; c >= 0 ; c--) if(NxN[core.r][c] != 0) return false;
				break;
			case 3:  //우
				for(int c = core.c+1 ; c < N ; c++)  if(NxN[core.r][c] != 0) return false;
				break;
		}
		return true;
	}
	
	//가능한 방향에서 직선(2) 표기, length 갱신
	static void coloringNxN(Core core, int dir) {
		switch(dir) {
			case 0:  //상
				for(int r = core.r-1 ; r >= 0 ; r--) { NxN[r][core.c] = 2; currentLength++; } 
				break;
			case 1:  //하
				for(int r = core.r+1 ; r < N ; r++)  { NxN[r][core.c] = 2; currentLength++; } 
				break;
			case 2:  //좌
				for(int c = core.c-1 ; c >= 0 ; c--) { NxN[core.r][c] = 2; currentLength++; }
				break;
			case 3:  //우
				for(int c = core.c+1 ; c < N ; c++)  { NxN[core.r][c] = 2; currentLength++; }
				break;
		}
		return;
	}
	
	//해당 방향 직선 해제, length 갱신
	static void deColoringNxN(Core core, int dir) {
		switch(dir) {
			case 0:  //상
				for(int r = core.r-1 ; r >= 0 ; r--) { NxN[r][core.c] = 0; currentLength--; } 
				break;
			case 1:  //하
				for(int r = core.r+1 ; r < N ; r++)  { NxN[r][core.c] = 0; currentLength--; } 
				break;
			case 2:  //좌
				for(int c = core.c-1 ; c >= 0 ; c--) { NxN[core.r][c] = 0; currentLength--; } 
				break;
			case 3:  //우
				for(int c = core.c+1 ; c < N ; c++)  { NxN[core.r][c] = 0; currentLength--; } 
				break;
		}
		return;
	}

}






























