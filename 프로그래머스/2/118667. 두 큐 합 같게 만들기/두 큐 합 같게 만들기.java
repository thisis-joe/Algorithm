import java.util.*;

class Solution {
    static long sum1, sum2;
    static long target;
    static int cnt;
    static Queue<Integer> q1 = new LinkedList<>();
    static Queue<Integer> q2 = new LinkedList<>();
        
    public int solution(int[] queue1, int[] queue2) {
        int len = queue1.length;
        int limit = 3*len;
        //초기화
        for(int n : queue1) {
            q1.offer(n);
            sum1 += n;
        }
        for(int n : queue2){
            q2.offer(n);
            sum2 += n;            
        } 
        
        //합이 홀수면 어떤 방법으로도 같게 만들 수 없고, 짝수인경우 target /=2
        target = sum1 + sum2;
        if(target % 2 != 0){
            return -1;
        }else{
            target /= 2;
        }
        
        //큐 이동
        while(cnt < 3*len){
            if(sum1 == target) return cnt;
            if(sum1 > target){ //q1합 > q2합  이므로 q1 -> q2로 이동
                int val = q1.poll();
                sum1 -= val;
                sum2 += val;
                q2.offer(val);
                
            }else if(sum1 < target){
                int val = q2.poll();
                sum1 += val;
                sum2 -= val;
                q1.offer(val);
            }
            cnt++;
        }
        
            
        return -1;
    }
}