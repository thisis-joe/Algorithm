import java.util.*;
class Solution {
    public String solution(String[] str_list, String ex) {
        List<String> strList = new ArrayList<>();
        
        for(String str:str_list){
            if(str.contains(ex)) continue;
            strList.add(str);
        }
        
        return String.join("",strList);
    }
}
