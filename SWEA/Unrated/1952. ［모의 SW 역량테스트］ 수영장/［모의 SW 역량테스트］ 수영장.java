import java.util.*;
import java.io.*;

public class Solution {
	static StringBuilder 	sb;
	static StringTokenizer 	st;
	static BufferedReader 	br;
	static int 				TC;
	
	static int prices[], plans[], minPrice;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		sb = new StringBuilder();
		br = new BufferedReader(new InputStreamReader(System.in));
	    TC = Integer.parseInt(br.readLine());

	    for (int tc = 1; tc <= TC; tc++) {
	    	
	    	st = new StringTokenizer(br.readLine()," ");
	    	prices = new int[4];
	    	for(int i = 0 ; i < 4 ; i++) 	prices[i] = Integer.parseInt(st.nextToken());
	    	
	    	st = new StringTokenizer(br.readLine()," ");
	    	plans = new int[12];
	    	for(int i = 0 ; i < 12 ; i++)  	plans[i] = Integer.parseInt(st.nextToken());
	    	
	    	minPrice = Integer.MAX_VALUE;
	    	dfs(0,0);
	    	
	    	sb.append("#").append(tc).append(" ").append(Math.min(minPrice, prices[3])).append("\n");
	    }
	    System.out.println(sb);
	    
	    br.close();
	}
	 
	static void dfs(int month, int currentSum) {
		//가지
		if(minPrice<=currentSum) {
			return;
		}
		//기저
		if(month>=12) {
			minPrice = Math.min(minPrice,currentSum);
			return;
		}
		//유도
		if(plans[month] == 0) {
			dfs(month+1,currentSum);
		}else {
			dfs(month+1,currentSum+prices[0]*plans[month]);
			dfs(month+1,currentSum+prices[1]);
			dfs(month+3,currentSum+prices[2]);
		}
	}

}
