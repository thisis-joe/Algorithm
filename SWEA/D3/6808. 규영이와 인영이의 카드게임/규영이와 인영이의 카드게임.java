

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static final int NINE = 9;
	static int GYUScore, IENScore, GYUWin, GYULose, IENCardArr[], IENiArr[];
	static List<Integer> GYUList;
	static int[] thisCase = new int[9]; 		// 재귀 호출끼리 인영이가 내는 카드 순서를 공유해야 함
	static boolean[] visited = new boolean[9]; 	// ''
	
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
          
        for (int test_case = 1; test_case <= T; test_case++) {
        	
        	GYUWin = GYULose = GYUScore = 0; //테스트케이스 초기화
        	
        	IENCardArr = new int[9];
        	GYUList = new ArrayList<>();
            IENiArr = new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18};
            
            //규영 입력, 인영 카드 확정
            StringTokenizer stk = new StringTokenizer(br.readLine());
            while(stk.hasMoreTokens()) {
            	int card = Integer.parseInt(stk.nextToken());
            	GYUList.add(card);
            	IENiArr[card-1] = -1;
            }
            IENCardArr = Arrays.stream(IENiArr).filter(a -> a!=-1).toArray();       
            
            //경우의 수(순열) 에서 게임 진행
            permutation(0);
            
            //결과 출력
        	System.out.println("#"+test_case+" "+GYUWin+" "+GYULose);
        }   
    }
    
    public static void permutation(int cnt) {
        
    	//종료
    	if(cnt == NINE) {
    		GYUScore = 0;
    		IENScore = 0;
    		
    		//인영 케이스 1개에 대한 게임 (총9판) 진행
    		for(int i = 0 ; i < NINE ; i++) {
    			int GYU =  GYUList.get(i);
    			int IEN = thisCase[i];
    			if(IEN < GYU) {
    				GYUScore += GYU + IEN;
    			}else {
    				IENScore +=  GYU + IEN;
    			}
    		}
    		
    		if(GYUScore > IENScore) {
    			GYUWin++;
    		}else {
    			GYULose++;
    		}
    		
    		//게임 초기화
//    		Arrays.fill(thisCase, 0);
//    		Arrays.fill(visited, false);
//    		
    		return;
    	}
    	
    	//유도
    	for(int i = 0 ; i < NINE ; i++) {
    		if(!visited[i]) {
            	visited[i] = true;
            	thisCase[cnt] = IENCardArr[i];
                permutation(cnt+1);
                visited[i] = false;
            }
    	}
    }
}