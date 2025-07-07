import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        
        for(int i = 0 ; i <= n ; i++){
            int sum = i;
            int m = i;
            while(m > 0){
                sum += m%10;
                m /= 10;
            }
            if(sum == n){
                System.out.println(i);
                return;
            }
        }
        System.out.println(0); //없으면 0
    }
    
    
}
