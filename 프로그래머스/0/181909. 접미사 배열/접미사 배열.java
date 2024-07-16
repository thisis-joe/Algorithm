import java.util.*;

class Solution {
    public String[] solution(String my_string) {
        int len = my_string.length();
        List<String> strList = new ArrayList<>();
        
        for(int i= 0; i<len;i++){
            strList.add(my_string.substring(i,len));
        }
        
        //리스트의 원소를 정렬하려면 Collections.sort()활용
        Collections.sort(strList);

        String answer = String.join(",",strList);
        return strList.stream().toArray(String[]::new);

    }
}