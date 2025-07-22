import java.util.*;

public class Main
{
    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    static int count = 0;
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		
		//그래프에 노드 등록
		graph = new ArrayList[N+1]; // N+1?
		for(int i = 1 ; i <= N ; i++){
		    graph[i] = new ArrayList<>();
		}
		
		//간선연결정보 등록
		for(int i = 0 ; i < M ; i++){
		    int nodeA = sc.nextInt();
		    int nodeB = sc.nextInt();
		    graph[nodeA].add(nodeB);
		    graph[nodeB].add(nodeA); //방향이 없는 그래프 = 양방향그래프 
		}
		
		//정렬은 필요없음. 순서대로 탐색할 필요는 없다
		
		//DFS
		visited = new boolean[N+1];
		
		for(int i = 1 ; i <= N ; i++){
		    if(!visited[i]){ //이게 핵심이네
		        dfs(i); 
		        count++;    
		    }
		}
		
		System.out.println(count);
		return;
	}
	
	public static void dfs(int node){
	    visited[node] = true;
	    //하나의 네트워크 내에서 방문처리
	    for(Integer next : graph[node]){
	        if(!visited[next]){
	            dfs(next);
	        }
	    }
	}
}








