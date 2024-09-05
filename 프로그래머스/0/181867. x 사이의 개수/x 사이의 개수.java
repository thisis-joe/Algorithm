import java.util.*;
class Solution {
    public int[] solution(String myString) {
        List<Integer> intList = new ArrayList<>();
        String[] strArr = myString.split("x",-1);
        for(int i=0;i<strArr.length;i++){
            intList.add(strArr[i].length());
        }
        return intList.stream().mapToInt(i->i).toArray();
    }
}