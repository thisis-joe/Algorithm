import java.util.*;

public class Main
{
    static int[][] dp = new int[30][30]; // 값 mCn = dp[m][n] 이다. 문제범위가 0 초과 30미만까지 입력되므로.
                                        // 또한, dp 값의 초기화는 불필요하다. 0초과 값만 들어오기 때문.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for(int i = 0 ; i < t ; i++){
		    int n = sc.nextInt();
		    int m = sc.nextInt();
		
		    System.out.println(combination(dp,m,n));    
		}
		
		
		return;
	}
	
	public static int combination(int[][] dp, int n, int r){
	    if(r==0 || n==r){
	        return 1;
	    }
	    
	    if(dp[n][r] !=0){
	        return dp[n][r];
	    }
	    
	    return dp[n][r] = combination(dp,n-1,r-1) + combination(dp,n-1,r);
	}
}
