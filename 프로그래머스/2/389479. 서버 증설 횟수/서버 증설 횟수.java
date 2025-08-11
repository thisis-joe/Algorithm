import java.util.*;
class Solution {
    public int solution(int[] players, int m, int k) {
        int addCount = 0;
        Map<String,Integer> serverManage = new HashMap<>(); //서버 각자에 대한 시간저장과 갱신이 필요
        
        for(int time = 0 ; time < 24 ; time++){
            // Iterator<String> keys = serverManage.keySet().iterator(); //순회하면서 삭제 필요 - forEach 부적합
            // while(keys.hasNext()){
            //     String key = keys.next();
            //     if(time - serverManage.get(key) > k){
            //         serverManage.remove(key);
            //     }
            // }
            // 1) 만료 제거: 시작시간 + k <= 현재시간 이면 만료
            Iterator<Map.Entry<String, Integer>> it = serverManage.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, Integer> e = it.next();
                if (time - e.getValue() >= k) { // <-- 핵심: >= k
                    it.remove();               // <-- 핵심: iterator.remove()
                }
            }
            
            int n = players[time];
            int curServer = serverManage.size();
            if(n * m > curServer * m){ //증설 필요
                int needServer = n / m ; //몇대 서버가 필요
                if(curServer < needServer){ //서버 증설이 필요
                    for(int i = 0; i < needServer - curServer; i++){
                        serverManage.put(time+"-"+i, time);
                        addCount++;
                    }
                }
            }
        }
        
        return addCount;
    }
}