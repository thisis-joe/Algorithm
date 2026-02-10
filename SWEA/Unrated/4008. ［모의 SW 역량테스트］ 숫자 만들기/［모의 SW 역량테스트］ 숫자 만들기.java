import java.io.*;
import java.util.*;

public class Solution {
	
	
	static int max,min,N,M,NUM[];
	static boolean Selected[];
	static List<Integer> OPList; // 0+  1-  2*  3/
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int TC = Integer.parseInt(br.readLine());

	    for (int tc = 1; tc <= TC; tc++) {
	    	max = Integer.MIN_VALUE;
	    	min = Integer.MAX_VALUE;
	    	
	    	N = Integer.parseInt(br.readLine());
	    	M = N-1;
	    	NUM 		= new int[N];
	    	Selected 	= new boolean[M]; //mPm
	    	OPList 		= new ArrayList<>();
	    	int idx = 0;
	    	StringTokenizer stk = new StringTokenizer(br.readLine());
	    	
	    	while(stk.hasMoreTokens()) {
	    		int howmany = Integer.parseInt(stk.nextToken());
	    		for(int i = 0 ; i < howmany;  i++){
	    			OPList.add(idx);
	    		}			 
	    		idx++;
    		 }
	    	
	    	idx = 0;
	    	stk = new StringTokenizer(br.readLine());
	    	while(stk.hasMoreTokens()) {
	    		NUM[idx++] = Integer.parseInt(stk.nextToken()); }
	    	
	    	//순열
	    	int res = NUM[0];
	    	operatorPerm(0, res);
	    	
	    	System.out.println("#"+tc+" "+ (max-min));
	    }
	}
	
	static void operatorPerm(int cnt, int result) {
		if(cnt == M) {
			
			max = Math.max(max, result);
			min = Math.min(min, result);
			return;
		}
		
		for(int i = 0 ; i < M ; i++) { //m
			if(Selected[i]) continue;
			if(i > 0 && OPList.get(i).equals(OPList.get(i-1)) && !Selected[i-1]) continue;
			int nextResult = result;
			switch(OPList.get(i)) {
				case 0: nextResult += NUM[cnt+1]; break;
				case 1: nextResult -= NUM[cnt+1]; break;
				case 2: nextResult *= NUM[cnt+1]; break;
				case 3: nextResult /= NUM[cnt+1]; break;
			}
			
			Selected[i] = true;
			operatorPerm(cnt+1,nextResult);
			Selected[i] = false;
		}
	}
}
