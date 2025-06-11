import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> rank = new HashMap<>();
        
        for(int i=0;i<players.length;i++){
            rank.put(players[i],i);
        }
        
        for(String call : callings){
            //순위 파악
            int callRank = rank.get(call);
            int preRank  = rank.get(call)-1;
            
            // HashMap 업데이트
            rank.put(call, preRank);
            rank.put(players[preRank], callRank);
            
            //순위 변경
            String temp       = players[callRank];
            players[callRank] = players[preRank];
            players[preRank]  = temp;
            
        }
        
        return players;
        
    }
}