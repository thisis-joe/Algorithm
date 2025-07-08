import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] strArr = Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);
        
        Arrays.sort(strArr, (a,b) -> (b+a).compareTo(a+b)); //2개 이어붙인 경우에서 큰 쪽으로 정렬
                
        if (strArr[0].equals("0")) return "0"; // "0"만 여러 개 있는 경우("000" 등) 처리
        
        return String.join("", strArr);
        
    }
}