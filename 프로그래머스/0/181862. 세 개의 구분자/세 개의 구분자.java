import java.util.*;
class Solution {
    public String[] solution(String myStr) {
        //정규표현식으로 split
        String[] strArr = myStr.split("[abc]");
        //빈문자열제거를 위해 리스트로 변환 -> remove -> 다시배열로변환
        List<String> strList = new ArrayList<>();
        int count=0;
        
        for(String str:strArr){
            if(!str.isEmpty()) {
                strList.add(str);
            }
            else count++;
        }
        
        if(count==strArr.length) strList.add("EMPTY");
        
        return strList.toArray(String[]::new);
    }
}