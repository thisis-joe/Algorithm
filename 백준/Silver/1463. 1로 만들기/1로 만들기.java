import java.util.*;

public class Main
{
    static int N;
    static boolean[] visited;
    static int count;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
	//BFS + DP
        Queue<Integer> queue = new LinkedList<>();
		queue.add(N);
		visited = new boolean[N+1]; //1번쨰부터..
		
		while(!queue.isEmpty()){
		    int size = queue.size(); ///?
		    
		    for(int i = 0 ; i < size ; i++){
		        int current = queue.poll();
		        
		        if(current == 1){
		            System.out.println(count);
		            return;
		        }
		        
		        //가능한 다음 연산 경우의 수 결정
		        ArrayList<Integer> next = new ArrayList<>();
		        if(current % 3 == 0 && current % 2 == 0){
		           next.add(current/3);
		           next.add(current/2); // 3 과 2 모두 나눠 떨어지면 두가지 경우로 갈라짐
		        }
		        else if(current % 3 == 0){
		            next.add(current/3);
		        }else if(current % 2 == 0){
		            next.add(current/2);
		        }
	            next.add(current-1);
	            
	            //방문하지 않은 곳에 대해서만 queue에 추가
	            for(Integer pos : next){
	                if(!visited[pos]){
	                    visited[pos] = true;
	                    queue.add(pos);
	                }
	            }
		        
		    }
		    count++;
		}
		
	}

}
