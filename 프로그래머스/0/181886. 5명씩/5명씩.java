import java.util.*;
class Solution {
    public String[] solution(String[] names) {
        List<String> strList = new ArrayList<>();
        for(int i=0;i<names.length;i+=5){
            strList.add(names[i]);
        }
        return strList.stream().toArray(String[]::new);
    }
}