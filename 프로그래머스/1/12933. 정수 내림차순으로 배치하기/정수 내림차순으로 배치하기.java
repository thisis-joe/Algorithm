import java.util.*;
class Solution {
    public long solution(long n) {
        String[] strArr = (n+"").split("");
        Arrays.sort(strArr);
        String str = String.join("",strArr);
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        return Long.parseLong(sb.toString());
    }
}