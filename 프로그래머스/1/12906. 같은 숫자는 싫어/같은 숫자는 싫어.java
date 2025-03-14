import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stk = new Stack<>();
        stk.push(arr[0]);
        for(int i=1;i<arr.length;i++){
            if(stk.peek()==arr[i])continue;
            else stk.push(arr[i]);
        }
            
        return stk.stream().mapToInt(i->i).toArray();
    }
}