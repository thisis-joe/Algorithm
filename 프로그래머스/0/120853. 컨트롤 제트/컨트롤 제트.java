import java.util.*;

class Solution {
    public int solution(String s) {
        Stack<String> stack = new Stack<>();
        String[] strArr = s.split(" ");
        for(String str : strArr){
            if(str.equals("Z")){
                stack.pop();
            }    
            else{
                stack.push(str);
            }
        }
        int sum=0;
        for(String ele : stack){
            sum+=Integer.valueOf(ele);
        }
        return sum;
        
    }
}