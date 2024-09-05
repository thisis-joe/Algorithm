import java.util.*;

class Solution {
    public String[] solution(String[] strArr) {
        // ArrayList로 변환
        List<String> strList = new ArrayList<>(Arrays.asList(strArr));
        
        // removeIf를 사용하여 "ad"가 포함된 문자열을 제거
        strList.removeIf(s -> s.contains("ad"));
        
        // List를 배열로 변환하여 반환
        return strList.toArray(new String[0]);
    }
}