import java.util.*;

public class Main{
    public static void main(String[] args){
    	
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n]; 
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        		
        for(int i = 0 ; i < n ; i++) {
        	arr[i] = sc.nextInt();
        	if(arr[i] < min) {
        		min = arr[i];
        	}
        	if(arr[i] > max) {
        		max = arr[i];
        	}
        }
        
        System.out.println(min+" "+max);
        
    }
}

