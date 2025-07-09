import java.util.*;

public class Main {
    //삼각수
    static int[] Tarr = new int[51];
    
    public static void main(String[] args) {
        //삼각수 저장
        for(int i = 1 ; i <= 50 ; i++){
            Tarr[i] = i*(i+1)/2; 
        } 
        
        //입력
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        //입력 및 삼각수 판단
        for(int i = 0 ; i < N ; i++){
            int num = sc.nextInt();
            if(is3TriNum(num)) System.out.println(1);
            else System.out.println(0);
        }
    }
    
    public static boolean is3TriNum(int num){
        for(int i = 1 ; i < 50; i++){
            for(int j = 1 ; j < 50 ; j++){
                for(int k = 1; k < 50; k++){
                    if(Tarr[i]+Tarr[j]+Tarr[k] == num) return true;
                }
            }
        }
        return false;
    }
}

