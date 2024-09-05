import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        List<Integer> stkList = new ArrayList<>();
        int i=0;
        while(i<arr.length){ 
            if(stkList.size()==0){ 
                stkList.add(arr[i]);
                i++;
            }
            else{
                if(stkList.get(stkList.size()-1)==arr[i]){ 
                    stkList.remove(stkList.size()-1);
                    i++;
                }
                else{
                    stkList.add(arr[i]);
                    i++;
                }
            }
        }
        return stkList.isEmpty() ? new int[]{-1} : stkList.stream().mapToInt(n -> n).toArray();
    }
}