import java.util.*;
class Solution {
    public int[] solution(int n, int k) {
        
        ArrayList<Integer> arrList = new ArrayList<>();
        
        for(int i=1;i<=n;i++){
            if(i%k==0) arrList.add(i);
        }
        
        //리스트를 정수 배열로 변환
        int[] answer = new int[arrList.size()]; //ArrayList의 크기는 size() 이다. (length()아님.)
        for(int i=0;i<arrList.size();i++){
            answer[i]=arrList.get(i);
        }
        
        return answer;
    }
}