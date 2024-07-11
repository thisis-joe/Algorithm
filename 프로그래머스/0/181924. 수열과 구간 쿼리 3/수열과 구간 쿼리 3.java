class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        
        for(int i=0; i<queries.length; i++){
            int[] alt = new int[queries[i].length];
            
            for(int j=0; j<queries[i].length; j++){
                alt[j] = queries[i][j];
            }
            
            int tmp = arr[alt[0]];
            arr[alt[0]] = arr[alt[1]];
            arr[alt[1]] = tmp;
            
        }
            
        return arr;
    }
}