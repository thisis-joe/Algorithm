import java.util.*;
			
public class Main{
    public static void main(String[] args){
    		
        Scanner sc = new Scanner(System.in);

        String str1 = sc.next();
        String str2 = sc.next();
        
        StringBuilder sb1 = new StringBuilder(str1);
        StringBuilder sb2 = new StringBuilder(str2);
        
        str1 = sb1.reverse().toString();
        str2 = sb2.reverse().toString();
        
        if(Integer.valueOf(str1) > Integer.valueOf(str2)) {
        	System.out.println(str1);
        }else {
        	System.out.println(str2);
        }
        
    }
}

// 