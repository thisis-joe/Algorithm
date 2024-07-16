import java.util.*;

class Solution {
    public int solution(String my_string, String is_suffix) {
        for(int i=0; i<my_string.length(); i++){
            String str = my_string.substring(i,my_string.length());
            if(str.equals(is_suffix)) return 1;
            else continue;
        }
        return 0;
    }
}