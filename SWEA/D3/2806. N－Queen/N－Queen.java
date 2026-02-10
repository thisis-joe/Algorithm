import java.util.*;
import java.io.*;


public class Solution {

	static int N, totalCnt;
	static boolean[] col,slash,bSlash;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int TC = Integer.parseInt(br.readLine());
	    
	    for (int tc = 1; tc <= TC; tc++) {
	    	totalCnt = 0;
	    	
	    	N = Integer.parseInt(br.readLine());
	    	col = new boolean[N+1]; //0열 X
	    	slash = new boolean[2*N-1];
	    	bSlash = new boolean[2*N]; 
	    	
	    	nQueen(1);
	    	
	    	System.out.println("#"+tc+" "+totalCnt);
	    }
	}
	
	static void nQueen(int row) {
		if(row > N) {
			++totalCnt;
			return;
		}
		
		for(int c = 1 ; c <= N ; c++) {
			if(col[c] || slash[row+c-2] || bSlash[row-c+N]) continue;
			
			col[c] = slash[row+c-2] = bSlash[row-c+N] = true;
			nQueen(row+1);
			col[c] = slash[row+c-2] = bSlash[row-c+N] = false;
		}
		
	}

}
