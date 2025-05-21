import java.util.*;
			
public class Main{
    public static void main(String[] args){
    		
        Scanner sc = new Scanner(System.in);
        	
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        
        for(int i = 1; i <= n ; i++) {
        	arr[i-1] = i;
        }
        	
        for(int i = 0 ; i < m ; i++) {
        	int a = sc.nextInt()-1;
        	int b = sc.nextInt()-1;
        	
        	//뒤집기 함수로 할 방법 생각안나서.
        	int times = (b-a+1)/2;
        	for(int j = 0; j < times; j++) {
        		int tmp = arr[a+j];
        		arr[a+j] = arr[b-j];
        		arr[b-j] = tmp;
        	}
        }
        
        for(int i = 0; i < n ; i++) {
        	System.out.print(arr[i]+" ");
        }
        
    }
}

