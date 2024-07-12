import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> stkList = new ArrayList<>();
        int i = 0;
        
        
        while(i<arr.length){ //배열 길이 구할떈 length() 아니고 length
            int sizeOfList = stkList.size();
            int endOfList = stkList.size()-1;
            if(sizeOfList !=0 && stkList.get(endOfList)<arr[i] ){ //ArrayList 값 가져오기: get
                stkList.add(arr[i]);
                i++;
            }
            else if(stkList.size()!=0 && stkList.get(endOfList)>=arr[i] ){
                stkList.remove(endOfList);
            }
            else if(stkList.size() == 0){
                stkList.add(arr[i]);
                i++;
            }
        }
        
        int[] stk = stkList.stream().mapToInt(I -> I).toArray();
        return stk;
    }
}