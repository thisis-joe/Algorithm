import java.util.*;

class Solution {
    public String solution(String code) {
        StringBuilder retsb = new StringBuilder();
        int mode = 0;
        for(int idx = 0; idx<code.length(); idx++){
            if(code.charAt(idx) == '1') {
                mode = 1 - mode ; //1과 0 스위칭 하는 방법!
            }
            else{
                if(mode==1) {
                    if(idx%2!=0) retsb.append(code.charAt(idx));
                }
                else if(mode==0) {
                    if(idx%2==0) retsb.append(code.charAt(idx));
                }
                }
            }
        String ret = retsb.toString();
        if(ret.equals("")) return "EMPTY";
        else return ret; 
 
    }
}
