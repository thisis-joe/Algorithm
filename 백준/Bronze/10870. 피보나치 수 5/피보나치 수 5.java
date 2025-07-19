import java.util.*;

public class Main
{
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] sum = new int[n+1];
        for(int i = 0 ; i < n+1 ; i++){
            if(i<=1){
                sum[i] = i;
            }
            else{
                sum[i] = sum[i-2]+sum[i-1];
            }
        }
        System.out.println(sum[n]);
        return;
	}
	
	
}
