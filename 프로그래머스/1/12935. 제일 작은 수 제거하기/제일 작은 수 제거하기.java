import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        List<Integer> intList = new ArrayList<>();
        int min = Integer.MAX_VALUE;

        if(arr.length==1) return new int[]{-1};
        
        for(int num : arr){
            if(min>num) min=num;
            intList.add(num);
        }
        
        intList.remove(intList.indexOf(min));
        
        return intList.stream().mapToInt(i->i).toArray();
        
    }
}