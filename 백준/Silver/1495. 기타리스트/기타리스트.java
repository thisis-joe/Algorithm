import java.util.*;

public class Main
{
    static int N;
    static int S;
    static int M;
    static int[] V;
    static Set<Integer>[] sets;
    
	public static void main(String[] args) {
        //외부입력
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = sc.nextInt();
        M = sc.nextInt();
        V = new int[N];
        
        //0번째 초기화
        sets = new HashSet[N+1]; 
        sets[0] = new HashSet<>();
        sets[0].add(S);
        
        //로직
        for(int i = 0 ; i < N ; i++){
            V[i] = sc.nextInt();
            sets[i+1] = new HashSet<>();//i+1
        }
        
        for(int i = 0 ; i < N ; i++){
            for(Integer ele : sets[i]){
                int low = ele - V[i];
                int high = ele + V[i];    
                
                if(low >= 0){
                    sets[i+1].add(low);
                }
                if(high <= M){
                    sets[i+1].add(high);
                }
            }
            
            if(sets[i+1].isEmpty()){ //이번 low high에서 모두 불가능했다면 sets[i]는 비어있다
                System.out.println(-1);
                return;
            }
        }
        
        int max = Integer.MIN_VALUE;
        for(Integer ele : sets[N]){
            if(max < ele){
                max = ele;
            }
        }
        System.out.println(max);
        return;
	}
}
