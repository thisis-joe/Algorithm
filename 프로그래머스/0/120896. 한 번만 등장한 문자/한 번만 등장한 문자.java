import java.util.*;
class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> strList = new ArrayList<String>(Arrays.asList(s.split("")));
        List<String> strListRes = new ArrayList<>();
        
        for(String c:strList){
            if(Collections.frequency(strList,c)==1) strListRes.add(c);  
        }
        
        String[] strArr = strListRes.stream().toArray(String[]::new);
        
        Arrays.sort(strArr);
        
        for(String str : strArr){
            sb.append(str);
        }
        
        return sb.toString();
    }
}