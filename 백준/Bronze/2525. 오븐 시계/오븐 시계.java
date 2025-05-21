import java.util.*;

public class Main{
    public static void main(String[] args){
    	
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        
        m+=k;
        if(m>=60) {
        	h += m/60;
        	m = m%60;
        	if(h>=24) {
        		h -= 24;
        	}
        }
        
        System.out.println(h+" "+m);
    }
}