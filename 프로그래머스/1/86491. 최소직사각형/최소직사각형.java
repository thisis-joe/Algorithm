import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        //가로가 길게, 세로가 짧게 미리 회전시킨다 (이게 아이디어)
        int maxLen=Integer.MIN_VALUE;
        int maxHei=Integer.MAX_VALUE;
        List<Integer> length = new ArrayList<>();
        List<Integer> height = new ArrayList<>();
        
        for(int[] size : sizes){
            int tmp=0;
            if(size[0]<size[1]){
                tmp     = size[1];
                size[1] = size[0];
                size[0] = tmp;
            }
            length.add(size[0]);
            height.add(size[1]);
        }
        
        return Collections.max(length)*Collections.max(height);
        
    }
}