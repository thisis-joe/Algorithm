import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(stk.nextToken());
		int P = Integer.parseInt(stk.nextToken());
		String DNA = br.readLine();
		StringTokenizer stk2 = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(stk2.nextToken());
		int c = Integer.parseInt(stk2.nextToken());
		int g = Integer.parseInt(stk2.nextToken());
		int t = Integer.parseInt(stk2.nextToken());
		
		//슬라이딩 윈도우(개수)
		int aCnt = 0, cCnt = 0, gCnt=0, tCnt=0;
		int cnt = 0;
		
		//최초 window
		for(char ch : DNA.substring(0, P).toCharArray()) { //DNA.substring(0, P)를 쓰면 내부적으로 문자열을 새로 생성하므로, 가능하면 위 코드처럼 charAt(i)를 사용해 바로 세는 것이 메모리에 더 좋습니다.
			if(ch=='A') aCnt++;
			else if(ch=='C') cCnt++;
			else if(ch=='G') gCnt++;
			else if(ch=='T') tCnt++;
		}
		if(aCnt >= a && cCnt >= c && gCnt >= g && tCnt >= t) cnt++;

		//슬라이딩
		for(int idx = P ; idx < S ; idx++) {
			
			//지움
			char add = DNA.charAt(idx);
			switch(add) {
				case 'A' : aCnt++; break;
				case 'C' : cCnt++; break;
				case 'G' : gCnt++; break;
				case 'T' : tCnt++; break;
				
			}
			//더함
			char remove = DNA.charAt(idx-P);
			switch(remove) {
				case 'A' : aCnt--; break;
				case 'C' : cCnt--; break;
				case 'G' : gCnt--; break;
				case 'T' : tCnt--; break;
			}
			
		
			
			if(aCnt<a || cCnt<c || gCnt<g || tCnt<t) continue;
			cnt++;
		}
		System.out.println(cnt);
	
		br.close();
	}
}
