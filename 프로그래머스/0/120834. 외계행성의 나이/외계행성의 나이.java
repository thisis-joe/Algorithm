
import java.util.*;
class Solution {
    public String solution(int age) {        
        String ageStr = String.valueOf(age);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<ageStr.length();i++){
            sb.append((char)(Character.getNumericValue(ageStr.charAt(i))+97));
        }
        return sb.toString();
    }
}