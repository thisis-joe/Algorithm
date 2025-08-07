import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        long sum1 = 0;
        long sum2 = 0;
        long target = 0;
        for(int n : queue1){
            sum1 += n;
            q1.offer(n);
        }
        for(int n : queue2){
            sum2 += n;
            q2.offer(n);
        }
        
        if((sum1 + sum2) % 2 != 0){
            return -1;
        }else{
            target = (sum1 + sum2) / 2;
        }
        
        int count = 0;
        int maxMove = 3 * q1.size(); 
        while(count < maxMove){
            if(sum1 < sum2){
                Integer val = q2.poll(); //null체크를 위해 Integer로 사용
                if(val != null) {
                    q1.offer(val);
                    sum1 += val;
                    sum2 -= val;
                }
            }else if(sum1 > sum2){
                Integer val = q1.poll();
                if(val != null){
                    q2.offer(val);
                    sum1 -= val;
                    sum2 += val;
                }
            }else{
                return count;
            }
            count++;
        }
        
        return -1;
    }
}