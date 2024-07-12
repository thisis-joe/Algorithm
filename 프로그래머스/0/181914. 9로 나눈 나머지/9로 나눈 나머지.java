import java.util.*;

class Solution {
    public int solution(String number) {
        int sum = 0;
        for(char c : number.toCharArray()){
            //sum += c; 로 하면 아스키값을 더한다
            // sum += Integer.valueOf(c); 마찬가지다.
            sum += Character.getNumericValue(c); // 이렇게 하거나, sum += c-'0' 도 가능하다.
        }
        System.out.println(sum);
        return sum%9;
    }
}