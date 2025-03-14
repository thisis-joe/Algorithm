import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Integer> stk = new Stack<>();
        
        for(char brace : s.toCharArray()){
            if(stk.size()==0) stk.push(1);
            else if(brace==')'){
                stk.pop();
            }else{
                stk.push(1);
            }
        }
        
        return stk.size() != 0 ? false : true ;
    }
}