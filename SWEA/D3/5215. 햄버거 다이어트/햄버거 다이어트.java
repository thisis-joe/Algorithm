import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

//

public class Solution {
	
	static int N, L, max;
	static boolean[] isSelected;
	static List<int[]> info;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for (int test_case = 1; test_case <= T; test_case++) {
        	//입력, 초기화
        	N=L=0;
        	max=-1;

        	StringTokenizer stk = new StringTokenizer(br.readLine());
        	N = Integer.parseInt(stk.nextToken());
        	L = Integer.parseInt(stk.nextToken());
        	
        	isSelected = new boolean[N];
        	info = new ArrayList<>(N);
        	for(int i = 0 ; i < N ; i++) {
        		String[] input = br.readLine().split(" ");
        		info.add(new int[] {Integer.parseInt(input[0]),Integer.parseInt(input[1])});
        	}
        	
        	//호출
        	subset(0);
        	
        	//출력
        	System.out.println("#" + test_case + " " + max);
        }
		br.close();
	}
	
	/*
	 * @param sum 	현재까지 뽑은 집합 원소들의 칼로리 총합
	 * */
	static void subset(int idx) {
		if(idx == N) {
			int tasteSum = 0;
			int calSum = 0;
			
			for(int i = 0 ; i < N; i++) {
				if(isSelected[i]) {
					tasteSum += info.get(i)[0];
					calSum += info.get(i)[1];
				}
			}
			
			if(calSum > L) return;
			
			max = Math.max(max, tasteSum);
			return;
		}
		
		isSelected[idx] = true;
		subset(idx+1); 
		
		isSelected[idx] = false;
		subset(idx+1);
	}
	
	
}
