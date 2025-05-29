import java.util.*;
import java.io.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Stack<String> cardStk1 = new Stack<>();
        Stack<String> cardStk2 = new Stack<>();
        String answer = "Yes";
        
        for(int i = cards1.length-1; i >= 0 ; i--){
            cardStk1.add(cards1[i]);
        }
        for(int i = cards2.length-1; i >= 0 ; i--){
            cardStk2.add(cards2[i]);
        }
        
        for(int i = 0 ; i < goal.length ; i++){
            if(!cardStk1.isEmpty() && goal[i].equals(cardStk1.peek())){  //!cardStk1.isEmpty()
                cardStk1.pop();
            }
            else if(!cardStk2.isEmpty() && goal[i].equals(cardStk2.peek())){
                cardStk2.pop();
            }
            else{
                answer = "No";
            }
        }
        
        return answer;
    }
}