import java.util.*;

class Solution {
    public int solution(int n, int w, int num) {
        //스택 객체 생성 및 배열 요소로 등록
        Stack<Integer>[] stks = new Stack[w]; 
        for(int i = 0 ; i < w ; i++){
            stks[i] = new Stack<>(); //w개의 스택 생성        
        }
        
        //스택에 값 등록
        int row = 0;
        int findStk = -1;
        
        loop:
        for(int i = 1 ; i <= n ; i+=w ){    //시작 값을 지정
                if(row % 2 == 0){           //짝수행 (0번째 행부터 시작)  
                    int stack = 0;
                    for(int j = i; j < i+w ; j++){
                        if(j==num) findStk = stack;
                        if(j > n) break loop;      //n을 넘을수 없음
                        if(stack > w-1) break; 
                        stks[stack].push(j);        //좌 -> 우 등록   
                        System.out.print("Stack["+stack +"]:"+j+" ");
                        stack++;
                    }
                }
                else{                       //홀수 행
                    int stack = w-1;
                    for(int j = i; j < i+w ; j++){
                        if(j==num) findStk = stack;
                        if(j > n) break loop;      
                        if(stack < 0) break;
                        stks[stack].push(j);        // 우 -> 좌 등록
                        System.out.print("Stack["+stack +"]:"+j+" ");
                        stack--;
                    }
                }
                System.out.println();
                System.out.println("findStk: "+ findStk);
            row++;    
        }
            
        //출력
        int count = 1;
        //for(int i = 0 ; i < stks[findStk].size(); i++){
        while (!stks[findStk].isEmpty()) {
            if(stks[findStk].peek() == num){
                return count;
                
            }else{
                stks[findStk].pop();
                count++;
            }
        }
        
        return count;
    }
}