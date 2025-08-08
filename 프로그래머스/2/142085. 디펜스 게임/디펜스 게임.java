import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int round = 0 ; round < enemy.length ; round++){
            n -= enemy[round];
            pq.add(enemy[round]);
            
            if(n < 0){ //n이 음수일때 현재까지의 최대 적의 수에서 k를 사용한 것으로 바꿔치기 하자.
                if(k > 0){ //k가 남아있어야 적용 가능하다. 
                    n += pq.poll();
                    k--;
                }
                else{ //n이 음수이고 k가 없으면 더이상 진행불가하다
                    return round; //라운드는 1라운드부터
                }
            }
            
        }
        
        return enemy.length;
    }
}