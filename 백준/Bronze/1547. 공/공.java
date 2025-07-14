import java.util.*;

public class Main
{
	public static void main(String[] args) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(1,1); map.put(2,2); map.put(3,3); //컵번호 - 컵위치
        
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        for(int i = 0; i < N; i++){
            int A = sc.nextInt();
            int B = sc.nextInt();
            
            int tmp = map.get(A);
            map.put(A,map.get(B));
            map.put(B,tmp);
        }
        
        for(Integer cup : map.keySet()){
            if(map.get(cup)==1) {
                System.out.println(cup); 
                return;
            }
        }
        
        System.out.println(-1);
	}
}
