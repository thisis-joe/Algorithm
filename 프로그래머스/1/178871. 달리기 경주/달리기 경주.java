import java.util.*;

class Solution {

 
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> rank = new HashMap<>();
        Map<Integer, String> revRank = new HashMap<>();
        
        //현재 등수저장, 반대 해시맵에도 저장
        for(int i=0 ; i<players.length ; i++){
            rank.put(players[i],i+1);
            revRank.put(i+1,players[i]);
        }
        
        //등수 갱신
        for(String call : callings){
            int pos = rank.get(call); // 현재 등수
            String pre = revRank.get(pos-1); // 바로 앞 선수
            revRank.put(pos, pre); // 바로 앞 선수 뒤로 한칸
            revRank.put(pos-1, call); // 현재 선수 앞으로 한칸
            rank.put(call, pos-1); // 업데이트
            rank.put(pre, pos);
        }
        
        //배열에 담기 
        String[] res = new String[players.length];
        for(int i = 0 ; i < players.length ; i++){
            res[i] = revRank.get(i+1);
        }
       
        
        return res;
    }
}
