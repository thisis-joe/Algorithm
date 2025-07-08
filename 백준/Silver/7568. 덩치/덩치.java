import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int rankInit = sc.nextInt();
        int[][] arr2 = new int[rankInit][3]; //키,몸무게,등수
        
        for(int i = 0 ; i < rankInit ; i++){
            arr2[i][0] = sc.nextInt();
            arr2[i][1] = sc.nextInt();
            arr2[i][2] = 1;
        }
        
        for(int i = 0 ; i < rankInit ; i++){
            for(int j = 0 ; j < rankInit ; j++){
                if(i==j) {
                    continue;
                }
                else if(arr2[i][0] < arr2[j][0] && arr2[i][1] < arr2[j][1]){
                    arr2[i][2] += 1;
                }
            }
        }
        
        for(int i = 0 ; i < rankInit ; i++){
            System.out.print(arr2[i][2]+" "); 
        }
    }
    
    
}
