import java.util.*;

public class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int numerator = factorial(N);
		int denomiator = factorial(K) * factorial(N-K);
		
        System.out.println(numerator/denomiator);
        
		return;
	}
	public static int factorial(int n){
	    if(n<=1){
	        return 1;
	    }
	    return n = n*factorial(n-1);
	}
}
