import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int minPrice, prices[], plan[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int TC = Integer.parseInt(br.readLine());

	    for (int tc = 1; tc <= TC; tc++) {
	    	prices = new int[4];
	    	plan = new int[12];

	    	minPrice = Integer.MAX_VALUE;
	    	
	    	StringTokenizer stk = new StringTokenizer(br.readLine()," ");
	    	for(int i = 0 ; i < 4 ; i++) 	prices[i] = Integer.parseInt(stk.nextToken());

	    	stk = new StringTokenizer(br.readLine()," ");
	    	for(int i = 0 ; i < 12 ; i++)  {
	    		plan[i] = Integer.parseInt(stk.nextToken());
	    	}	
	    	
	    	dfs(0,0);
	    	
	    	System.out.println("#"+tc+" "+Math.min(minPrice,prices[3]));
	    }
	}
	
	static void dfs(int month, int currentSum) {
	    if (month >= 12) {
	        minPrice = Math.min(minPrice, currentSum);
	        return;
	    }
	    
	    if (plan[month] == 0) {
	        dfs(month + 1, currentSum);
	    } else {
	        dfs(month + 1, currentSum + (plan[month] * prices[0]));

	        dfs(month + 1, currentSum + prices[1]);

	        dfs(month + 3, currentSum + prices[2]);
	    }
	    
		
	}

}
