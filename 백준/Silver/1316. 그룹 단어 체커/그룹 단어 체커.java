import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int a = sc.nextInt();
        int cnt = 0 ;
        
        for(int i = 0 ; i < a ; i++) {
        	String str = sc.next();
        	if(isGroupWord(str)) {
        		cnt++;
        	}
        }
        
        System.out.println(cnt);
        
    }
    
    public static boolean isGroupWord(String str) {
    	boolean[] seen = new boolean[26];
    	char prev = ' ';
    	
    	for(int i = 0 ; i < str.length() ; i++) {
    		char c = str.charAt(i);
    		if(c != prev) { //하나씩 넘어가면서 이전 문자와 비
    			if(seen[c - 'a']) { //
    				return false;
    			}
    			seen[c - 'a'] = true;
    			prev = c;
    		}
    	}
    	
    	return true;
    }
    
}