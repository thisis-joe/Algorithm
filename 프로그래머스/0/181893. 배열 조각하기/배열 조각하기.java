import java.util.*;
class Solution {
    public int[] solution(int[] arr, int[] query) {
        int start = 0, end = 0;
        
        for(int i=0;i<query.length;i++){
            if(i%2==0){
                end = start+query[i]+1;
            }
            else{
                start = start+query[i];
            }
        }
        return Arrays.copyOfRange(arr,start,end);//Arraycopy를 사용!
    }
}