import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        
        // 키-값 이 이름-동명이인수 로 구성된 맵 작성
        for(String person : participant){
            if(map.get(person)!=null){ // 동명이인 시 1명 추가
                map.put(person,map.get(person)+1); 
            }
            else{
                map.put(person,1); // person이 존재하지 않으면 1명으로 설정
            }
        }
        
        for(String person : completion){
            if(map.get(person)!=0){ // 0명이 아니면 1명을 낮춤.
                map.put(person,map.get(person)-1);
            }
        }
        
        //map에서 값이 0이 아닌 person을 반환
        List<String> strList = new ArrayList<>();
        Iterator<String> mapItr = map.keySet().iterator(); //iterator도 타입이 필요하며, map의 keySet에 대한 iterator로 지정.
        
        while(mapItr.hasNext()){
            String key = mapItr.next(); // iterator에서 다음번을 가리키도록 함.
            if(map.get(key)!=0){
                strList.add(key);
            }
        }
        
        return strList.get(0);
        
    }
}