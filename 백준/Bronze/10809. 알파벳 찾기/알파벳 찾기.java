import java.util.*;
			
public class Main{
    public static void main(String[] args){
    		
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[26];
        Arrays.fill(arr, -1); // 없다고 치자 
        
        String str = sc.next();
        
        //String[] strArr = str.split("");
        
        for(int i = 0 ; i < str.length() ; i++) {
        	int idx = (str.charAt(i) - 'a');
        	
        	if(arr[idx] == -1 ) {
        		arr[idx] = i;
        	}
        }
        
        for(int i = 0 ; i < 26 ; i ++) {
        	System.out.print(arr[i]+" ");
        }
      
        
        
    }
}
