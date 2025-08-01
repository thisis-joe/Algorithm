import java.util.*;

public class Main
{
    static int N;
    static int S;
    static int M;
    static int[] vol;
    static List<Integer>[] graph;
    static int max = -1;
    
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        S = sc.nextInt();
        M = sc.nextInt();
        vol = new int[N];
        graph = new ArrayList[N+1];
        
        
        
        for(int i = 0 ; i < N ; i++){
            vol[i] = sc.nextInt();
        }
        
        for(int i = 0 ; i < N+1 ; i++){
            graph[i] = new ArrayList<>();
        }
        
        graph[0].add(S);
        
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < graph[i].size() ; j++){
                int lowerVol = graph[i].get(j) - vol[i];
                int upperVol = graph[i].get(j) + vol[i];
                
                // if(lowerVol < 0 && upperVol > M){
                //     System.out.println(max);
                //     return;
                // }
                // -> 이는 한 노드에서만 판단하는 조건이므로, 다른 노드에서는 경로가 있을 수 있음에도 불구하고 중간에 탐색을 종료해버림.
                
                if(lowerVol >= 0 && !graph[i+1].contains(lowerVol)) {
                    graph[i+1].add(lowerVol);   
                }
                if(upperVol <= M && !graph[i+1].contains(upperVol)) {
                    graph[i+1].add(upperVol);   
                }
            }
            
        }
        
        if(graph[N].isEmpty()){ //마지막 depth가 비어있다면, 가능한 경우가 없다는 의미.
            System.out.println(-1);
            
        }
        else{
            for(int i = 0; i < graph[N].size() ; i++){
                int node = graph[N].get(i);
                if(max < node){
                    max = node;
                } 
            }    
            System.out.println(max);
        }
        
        return;
	}
}
