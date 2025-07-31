import java.util.*;

public class Main
{
    static int[][] memo = new int[1001][1001];  // 메모이제이션 캐시
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int sum = 0;
		//가로 최대
		int horizontalMax = N/2;
		
		for(int horizontal = 0 ; horizontal <= horizontalMax ; horizontal++){
		    int vertical = N - horizontal * 2;
		     sum = (sum + combi(vertical + horizontal, horizontal)) % 10007;
		}
		
		System.out.println(sum);
		return;
	}
	
	public static int combi(int n,int m){
	    if(m==0 || n==m){
	        return 1;
	    }
	     // 이미 계산된 값이 있다면 그 값을 바로 반환
        if (memo[n][m] != 0) return memo[n][m];


        return memo[n][m] = (combi(n - 1, m - 1) + combi(n - 1, m)) % 10007;
	}
}
