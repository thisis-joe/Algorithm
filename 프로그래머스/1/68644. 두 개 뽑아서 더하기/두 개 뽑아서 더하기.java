import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> intSet = new HashSet<>();
        for(int i=0;i<numbers.length-1;i++){
            for(int j=i+1;j<numbers.length;j++){
                intSet.add(numbers[i]+numbers[j]);
            }
        }
        int[] resArr = intSet.stream().mapToInt(i->i).toArray();
        Arrays.sort(resArr);
        return resArr;
    }
}