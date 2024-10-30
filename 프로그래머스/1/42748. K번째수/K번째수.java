import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> resList = new ArrayList<>();
        for(int[] cmd : commands){
            List<Integer> intList = new ArrayList<>();
            for(int i=cmd[0]-1;i<=cmd[1]-1;i++){
                intList.add(array[i]);
            }
            int[] temp = intList.stream().mapToInt(i->i).toArray();
            Arrays.sort(temp);
            resList.add(temp[cmd[2]-1]);
        }
        return resList.stream().mapToInt(i->i).toArray();
    }
}