import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i = 0 ; i < commands.length ; i++){
            ArrayList<Integer> intList = new ArrayList<>();    
            for(int j = commands[i][0]-1 ; j <= commands[i][1]-1 ; j++){
                intList.add(array[j]);
            }
            int[] arr = intList.stream().mapToInt(a->a).toArray();

            Arrays.sort(arr);
            answer[i] = arr[commands[i][2]-1];
        }
        
        return answer;
    }
}