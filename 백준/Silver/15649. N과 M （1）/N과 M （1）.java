import java.util.*;

public class Main
{
    static boolean[] visited;
    static int[] permutation;
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		visited = new boolean[N];
		permutation = new int[M];
		
		backTrack_DFS(N,M,0);
		
		return;
	}
	
	public static void backTrack_DFS(int N,int M,int count){
	    if(count == M){ //M을 사용하려면 받아와야지
	        for(int num : permutation){
	            System.out.print(num+" ");    
	        }
	        System.out.println();
	        return;
	    }
	    else{
	        for(int i = 0 ; i < N ; i++){ //N을 사용하려면 받아와야지
	            if(!visited[i]){
	                visited[i] = true;
	                permutation[count] = i+1;
	                backTrack_DFS(N,M,count+1);
	                visited[i] = false;
	            }
	        }
	        return;
	    }
	}
}
