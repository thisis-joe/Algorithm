import java.util.*;

class Solution {
    static int[] map; // p 번째 원소 k : p열 k행 에 퀸 존재를 의미
    static int caseCnt = 0;
    
    public int solution(int n) {
        map = new int[n];
        
        nQueen(0, n);
        
        return caseCnt;
    }
    
    public static void nQueen(int col,int n){
        if(col == n){ //마침내 퀸은 마지막 열에서도 가능한 위치가 있다. 케이스 추가
            caseCnt++;
            return;
        }
        
        for(int row = 0 ; row < n ; row++){ // 행을 하나씩 내려간다.
            map[col] = row;
            
            if(isPossible(col)){      // 다음 열에서 퀸이 위치할 곳이 있으면
                nQueen(col+1,n); // 그 다음열을 보러 가자.
            }
        }
    }
    
    public static boolean isPossible(int col){
         // preCol는 이전에 이미 배치한 열들을 확인
        for (int preCol = 0; preCol < col; preCol++) { 
            if(map[preCol] == map[col]){ //행이 같음 
                return false;
            }
            if(Math.abs(map[preCol]-map[col]) 
                == Math.abs(preCol-col)){  //대각선이 같음
                return false;
            }
        }
        return true;
    }
}