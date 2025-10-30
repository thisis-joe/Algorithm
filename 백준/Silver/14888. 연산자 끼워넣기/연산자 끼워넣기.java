import java.util.*;
import java.io.*;

public class Main
{
    public static int max = Integer.MIN_VALUE;
    public static int min = Integer.MAX_VALUE;
    public static int[] arr;
    public static int[] op = new int[4];
    public static int n;
    
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);	
	    n = sc.nextInt();
	    arr = new int[n];
	    
	    for(int i = 0 ; i < n ; i++){
	        arr[i] = sc.nextInt();
	    }
	    
	    for(int i = 0 ; i < 4 ; i++){
	        op[i] = sc.nextInt();
	    }
	    
	    //피연산자인 숫자들은 순서대로 그대로 있고, 연산자의 종류만 재귀로 돌리면서 개수를 차감해보자.
	    //idx가 1인 이유는 최초의 계산에서 0번째 값과 계산해야 하는 idx가 1번째이기 떄문이다. idx를 0을 넣으면 0번째 값이 두번 계산된다.
	    dfs(arr[0],1); 

	    System.out.println(max);
	    System.out.println(min);
	    
	    return;
	}
	
	public static void dfs(int num,int idx){ //value : 현재까지 계산된 값 , idx : 다음에 사용할 숫자의 인덱스
	
	    if(idx == n){
	        max = Math.max(max, num); //연산자를 모두 사용한 하나의 수식의 결과값에 대해 max 갱신하고 리턴
            min = Math.min(min, num); //연산자를 모두 사용한 하나의 수식의 결과값에 대해 min 갱신하고 리턴
	        return;
	    }
	    
	    for(int i = 0 ; i < 4 ; i++){ //연산자를 하나씩 봅니다.
	        if(op[i] > 0){
	            op[i]--; //연산자 1개 사용
	            
	            // 어떤 연산자(i)인지에 따라 계산을 하고,
                //    다음 숫자를 사용하기 위해 재귀 호출을 합니다.
                //    (다음 숫자의 인덱스는 idx + 1)
                switch (i) {
                    case 0: // 덧셈 (+)
                        dfs(num + arr[idx], idx + 1); // 점점 깊어짐..
                        break;
                    case 1: // 뺄셈 (-)
                        dfs(num - arr[idx], idx + 1);
                        break;
                    case 2: // 곱셈 (*)
                        dfs(num * arr[idx], idx + 1);
                        break;
                    case 3: // 나눗셈 (/)
                        dfs(num / arr[idx], idx + 1); 
                        break;
                }

                // 재귀 호출이 모두 끝나고 되돌아온 시점. (이번 경우의 수들에 대해 완료하고 돌아옴.)
                // 다른 경우의 수를 탐색하기 위해, 사용했던 연산자를 반납.
                
                op[i]++;
	        }
	    }
	    
	    
	    
	    
	    
	}

}
