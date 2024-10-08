import java.util.*;
class Solution {
    public int[] solution(int[] num_list) {
        List<Integer> intList = new ArrayList<>();
        for(int num:num_list){
            intList.add(num);
        }
        Collections.reverse(intList);
        return intList.stream().mapToInt(i->i).toArray();
    }
}