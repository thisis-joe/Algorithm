import java.util.*;

public class Main
{
    static int[] dy = {0,0,1,-1};
    static int[] dx = {1,-1,0,0};
    static boolean[][] visited;
    static boolean[][] field;
    static ArrayList<Integer> answer;
    static int N;
    
	public static void main(String[] args) {
        //입력
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); sc.nextLine();
        
        field = new boolean[N][N];
        visited = new boolean[N][N];
        answer = new ArrayList<>();
        
        //field 입력 및 채우기
        for(int i = 0 ; i < N ; i++){
            String[] str = sc.nextLine().split("");
            for(int j = 0 ; j < N ; j++){
                field[i][j] = str[j].equals("1") ? true : false;
            }
        }
        
        for(int y = 0 ; y < N ; y++){
            for(int x = 0 ; x < N ; x++){
                //언제 dfs를 실행할까?
                if(!visited[y][x] && field[y][x]){
                    int count = dfs(y,x);    
                    answer.add(count);
                }
            }
        }
        
        //정렬 및 출력
        Collections.sort(answer);
        System.out.println(answer.size()); // 단지 수 출력
        for(int i = 0; i < answer.size() ; i++){
            System.out.println(answer.get(i));
        }
        return;
	}
	
	public static int dfs(int y,int x){
	    visited[y][x] = true;
	     int count = 1; // 자기 자신 포함
	    
	    for(int i = 0; i < 4; i++){
	        int ny = y + dy[i];
	        int nx = x + dx[i];
	        
	        if(ny >= 0 && nx >= 0 && ny < N && nx < N
	            && !visited[ny][nx] && field[ny][nx]   //여기를 ny로 해야한다 . 실수
	            ){
	                count += dfs(ny,nx);
	            }
	    }
	    
	    return count;
	}
}






















