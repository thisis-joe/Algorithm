import java.util.*;
class Solution {
    public String[] solution(String[] todo_list, boolean[] finished) {
        List<String> strList = new ArrayList<>();
        for(int i=0;i<finished.length;i++){
            if(finished[i]==false){
                strList.add(todo_list[i]);
            }else continue;
        }
        return strList.toArray(new String[strList.size()]);
    }
}