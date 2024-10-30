import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> myStack = new Stack<>();
        for(int ele : arr){
            if(myStack.isEmpty() || myStack.peek()!=ele){
                myStack.push(ele);
            }
            else{
                continue;
            }
        }
        
        //스택 to int[]
        return myStack.stream().mapToInt(i->i).toArray();
    }
}