import java.util.*;
import java.lang.*;
class Solution {
    public int solution(String binomial) {
        List<String> strList = new ArrayList<>();
        String[] strArr = binomial.split("\\s+");
        
        switch(strArr[1]){
            case "+":
                return Integer.valueOf(strArr[0]) + Integer.valueOf(strArr[2]);
            case "-":
                return Integer.valueOf(strArr[0]) - Integer.valueOf(strArr[2]);
            case "*":
                return Integer.valueOf(strArr[0]) * Integer.valueOf(strArr[2]);
        }
        return -1;
    }
}