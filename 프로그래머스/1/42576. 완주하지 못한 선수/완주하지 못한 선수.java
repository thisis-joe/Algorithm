import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        //마라톤 완주자 맵
        Map<String, Integer> compMap = new HashMap<>();
        //완주자 목록을 순회하면서 맵에 완주자 키-값이 없으면 (완주자 이름, +1) 등록
        for(String str : completion){
            if(compMap.get(str)==null){
                compMap.put(str,1);    
            }
            else{
                compMap.put(str,compMap.get(str)+1);    
            }
        }
        //참가자 목록을 순회하면서, 완주자 맵에 존재하면 값-1수행, 존재하지 않으면 즉시 해당 이름을 반환
        for(String str : participant){
            if(compMap.get(str)==null){
                return str;
            }
            else{
                compMap.put(str,compMap.get(str)-1);
            }
        }
        //완주자 맵에서 값이 0이 아닌 사람 = 완주하지 못한 사람 (동명이인)
        for(String key : compMap.keySet()){
            if(compMap.get(key)!=0) return key;
        }
        //도달하지 않는 문장
        return "";
    }
}
