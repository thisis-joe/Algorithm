class Solution {
    public int[] solution(int[] arr, int[][] queries) {
       // int[] answer = {};
        int s = 0, e = 0, k = 0;
        
        for(int[] query : queries){
            s = query[0];
            e = query[1];
            k = query[2];
            for(int i = s; i <= e; i++){
                if(i % k == 0) arr[i] = arr[i] + 1;
            }
            
        }
        
        
        return arr;
    }
} 