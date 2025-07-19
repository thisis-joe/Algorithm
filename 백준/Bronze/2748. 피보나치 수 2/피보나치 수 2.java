import java.util.Scanner;
 
public class Main {
 
	static Long[] arr;
    
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
        
		arr = new Long[N + 1];
 
		arr[0] = 0L;
		arr[1] = 1L;
		System.out.println(Fib(N));
	}
	
	public static long Fib(int N) {
		if(arr[N] == null) {
			arr[N] = Fib(N - 1) + Fib(N - 2);
		}
		return arr[N];
	}
 
}
