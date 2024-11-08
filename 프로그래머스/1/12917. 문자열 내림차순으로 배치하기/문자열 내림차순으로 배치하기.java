import java.util.*;
class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        String[] strArr = s.split("");
        List<String> strList = new ArrayList<>(Arrays.asList(strArr));
        Collections.sort(strList);
        for(int i=0;i<strList.size();i++){
            sb.append(strList.get(i));
        }
        return sb.reverse().toString();
    }
}