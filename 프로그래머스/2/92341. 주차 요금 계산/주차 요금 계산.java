import java.util.*;
//10초
class Solution {
    public int[] solution(int[] fees, String[] records) {
        // 차량번호, (입차시간, 출차시간) 의 자료구조 Map<Integer, Map<Integer,Integer>> myRecords = new HashMap<>();
        // 차량별 누적 주차 시간을 계산하여 요금을 일괄로 정산합니다.
        Map<Integer, Integer> inRecord = new HashMap<>();// 차량번호, 입차시간                   
        Map<Integer, Integer> outRecord = new HashMap<>();// 차량번호, 출차시간
        Map<Integer, Integer> totalTime = new HashMap<>();// 차량번호, 총 시간
        
        int baseTime = fees[0];
        int baseFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];
        int maxTime = 23*60 + 59;
        
        for(String record : records){
            String[] row = record.split(" ");
            String[] timeStr = row[0].split(":");
            int time = Integer.parseInt(timeStr[0]) * 60 + Integer.parseInt(timeStr[1]);
            int car = Integer.parseInt(row[1]);
            totalTime.putIfAbsent(car, 0); // 해당 자동차 번호등록, 시간은 0초기화 
            
            if(row[2].equals("IN")){
                inRecord.put(car, time);
                outRecord.put(car, maxTime); //기본적으로 출차시간은 23:59로 초기화
                
            }else if(row[2].equals("OUT")){
                outRecord.put(car,time); //해당 차의 출차시각 덮어쓰기
                    
                int caseTime = outRecord.get(car) - inRecord.get(car);
                totalTime.put(car,totalTime.get(car) + caseTime);
                
                inRecord.remove(car);
                outRecord.remove(car); //Out을 만난경우 삭제
            }
        }
        
        //OUT 없는 IN 애들 시간 더해줌
        for(Integer noOut : inRecord.keySet()){
            int caseTime = maxTime - inRecord.get(noOut);
            totalTime.put(noOut,totalTime.get(noOut) + caseTime);
        }
        
        //정답 출력을 위해 배열로 변경
        //차량 번호가 작은 자동차부터 - how??
        //Map의 키 오름차순으로 정렬이 가능한가?
        // 차량 번호 오름차순으로 정렬 후 요금 계산
        
        //총 시간에 대해 한번만 요금 계산
        List<Integer> carList = new ArrayList<>(totalTime.keySet());
        Collections.sort(carList);
        int[] answer = new int[carList.size()];
        
        for (int i = 0; i < carList.size(); i++) {
            int time = totalTime.get(carList.get(i));
            if(time <= baseTime){
                answer[i] = baseFee;   
            }
            else{
                answer[i] = baseFee + (int)Math.ceil((double)(time-baseTime)/unitTime) * unitFee;
            }
            
        }

        return answer;
        
        
    }
}