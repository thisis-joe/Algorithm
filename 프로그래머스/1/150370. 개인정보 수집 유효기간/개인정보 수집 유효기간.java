import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        //오늘 날짜로 파기해야 할 개인정보 번호들을 구하기
        List<Integer> result = new ArrayList<>();
        Map<String, Integer> term = new HashMap<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd"); //mm은 분을 의미
        
        LocalDate todayYMD = LocalDate.parse(today, formatter);
        
        
        for(String str : terms){
            String[] eachCase = str.split(" ");
            term.put(eachCase[0], Integer.parseInt(eachCase[1]));
        }
        
        for(int i=0; i<privacies.length; i++){
            String[] privacy = privacies[i].split(" ");
            
            if(term.containsKey(privacy[1])){
                // 개인정보 수집 날짜를 LocalDate로 파싱
                LocalDate privacyDate = LocalDate.parse(privacy[0], formatter);
                // if(privacyDate.plusMonths(term.get(privacy[1])).isBefore(todayYMD)){
                //     result.add(i+1);
                // }
                
                // 유효기간을 더한 날짜 계산
                LocalDate expirationDate = privacyDate.plusMonths(term.get(privacy[1]));
                
                // 오늘 날짜와 비교하여 파기해야 할 경우 추가
                if (expirationDate.isBefore(todayYMD) || expirationDate.isEqual(todayYMD)) {
                    result.add(i + 1);
                }
            }
        }
        
        return result.stream().mapToInt(i->i).toArray();
    }
}