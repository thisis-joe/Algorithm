import java.util.*;
			
public class Main{
    public static void main(String[] args){
    		
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] answer = new String[n];
        
        for(int i = 0 ; i < n ; i++) {
        	String str = sc.next();
        	answer[i] = "" + str.charAt(0) + str.charAt(str.length()-1);
        }
        
        for(String str : answer) {
        	System.out.println(str);
        }
        
    }
}
