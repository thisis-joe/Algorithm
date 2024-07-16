import java.util.*;
//배열을 동적으로 늘릴려면 ArrayList 사용
//배열 원소 개수는 length

class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        List<Integer> resultList = new ArrayList<>();
        
        for(int i = 0; i < intStrs.length; i++){ 
            String intStr = intStrs[i].substring(s,s+l);
            int intStrValue = Integer.valueOf(intStr);
            if(k < intStrValue){
                //Arrays.aslist(answer).add(intStrValue); 
                resultList.add(intStrValue);
            }     
        }
        return resultList.stream().mapToInt(i -> i).toArray();
    }
}