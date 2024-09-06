import java.util.*;
class Solution {
    public int[] solution(int[] arr, int k) {
        List<Integer> intList = new ArrayList<>();
        for(int i=0;intList.size()<k;i++){
            try{
                if(!intList.contains(arr[i])) intList.add(arr[i]);
               
            }catch(Exception e){
                intList.add(-1);
                
            }
        }
        return intList.stream().mapToInt(i->i).toArray();
    }
}