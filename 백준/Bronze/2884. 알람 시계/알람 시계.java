import java.util.*;

public class Main{
    public static void main(String[] args){
    	
        Scanner sc = new Scanner(System.in);
        int H = sc.nextInt();
        int M = sc.nextInt();
        
        int a = M-45;
        int b = 15+M;
        
        if(M >= 45) {
        	System.out.println(H+" "+a);
        }
        else if(H==0) {
        	System.out.println("23 "+b);
        }
        else {
        	System.out.println(H-1+" "+b);
        }
    }
}