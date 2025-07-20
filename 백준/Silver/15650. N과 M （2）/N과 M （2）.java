import java.util.*;

public class Main
{
    static int permutation[];
    static int N;
    static int M;
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		permutation = new int[M];
		
	    dfs(1,0);	//시작 숫자 = 1, 길이  //왜 시작숫자가 필요할까?
		
	    return;	
	}
	
	// 중복되는 수열을 여러 번 출력하면 안된다.
	public static void dfs(int start, int count){
	    if(count == M){
	        for(int num : permutation){
	            System.out.print(num+" ");
	        }
	        System.out.println();
	        return;
	    }
	    
	    for(int i = start ; i <= N ; i++){
            permutation[count] = i;
            dfs(i+1, count+1);
	    }
	    return;
	}
	
}
