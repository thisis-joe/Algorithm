import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = new int[9];
        
        for(int i = 0 ; i < 9 ; i++){
            arr[i] = sc.nextInt();
        }
        
        Arrays.sort(arr);
        int sum = Arrays.stream(arr).sum();
        int liar1 = -1, liar2 = -1;
        
        //가능한 합의 개수는 9C2 개이다. 
        //전체 합 - 2개 선택해서 더한 값 = 100 이면 됨
        
        Loop_Finding :
        for(int i = 0 ; i < 8 ; i++){
            for(int j = i+1 ; j < 9 ; j++){
                if(sum - (arr[i]+arr[j]) == 100){
                    liar1 = i;
                    liar2 = j;
                    //System.out.println("liar1 :"+liar1+"-liar2 :"+liar2);
                    break Loop_Finding;
                }
            }
        }
        
        for(int i = 0 ; i < 9; i++){
            if(i==liar1 || i==liar2) continue;
            else System.out.println(arr[i]);
        }
        
        return;
    }
    
    
}
