import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        //내 로또번호, 당첨번호를 각각 다른 set에 넣는다
        //contain-> 일치개수 +1 
        //0의 개수는 따로 세고, 모두 틀릴경우(+0) & 모두 같은 경우(+0의개수) = 정답
        
        int[] result = new int[2];
        //Set<Integer> lottosSet = new HashSet<>();
        Set<Integer> win_sumsSet = new HashSet<>();
        int zeroCnt = 0 ;
        int sameCnt = 0;
        int maxRankCnt = 0;
        
        for(int n : win_nums){
            win_sumsSet.add(n);
        }
        
        for(int n : lottos){
            if(n==0) zeroCnt++;
            if(win_sumsSet.contains(n)) sameCnt++;
        }
        maxRankCnt = sameCnt + zeroCnt;
            
        switch(sameCnt){
            case 6: result[1] = 1; break;
            case 5: result[1] = 2; break;
            case 4: result[1] = 3; break;
            case 3: result[1] = 4; break;
            case 2: result[1] = 5; break;
            default : result[1] = 6; break;
        }
        
        switch(maxRankCnt){
            case 6: result[0] = 1; break;
            case 5: result[0] = 2; break;
            case 4: result[0] = 3; break;
            case 3: result[0] = 4; break;
            case 2: result[0] = 5; break;
            default : result[0] = 6; break;
        }
        
        
        
        return result;
    }
}