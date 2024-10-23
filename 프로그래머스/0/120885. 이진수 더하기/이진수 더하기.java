import java.util.*;

class Solution {
    public String solution(String bin1, String bin2) {
        int bin1pos = bin1.length() - 1;
        int bin2pos = bin2.length() - 1;
        int carry = 0; // 올림
        StringBuilder result = new StringBuilder();

        while (bin1pos >= 0 || bin2pos >= 0 || carry > 0) {
            int bit1 = bin1pos >= 0 ? Character.getNumericValue(bin1.charAt(bin1pos)) : 0;
            int bit2 = bin2pos >= 0 ? Character.getNumericValue(bin2.charAt(bin2pos)) : 0;

            int sum = bit1 + bit2 + carry;
            result.append(sum % 2); // 현재 자리의 값 추가 (0 또는 1)
            carry = sum / 2; // 다음 자리로의 올림값 (0 또는 1)

            bin1pos--; 
            bin2pos--;      
        }

        return result.reverse().toString();
    }
}