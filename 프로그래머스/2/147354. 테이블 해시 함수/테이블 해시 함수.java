import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        
        Arrays.sort(data, (data1, data2) -> {
            if(data1[col-1] != data2[col-1]){
                return Integer.compare(data1[col-1], data2[col-1]);
            }
            else{
                return Integer.compare(data2[0], data1[0]);
            }
        });
        
        
        int SiAccu = 0;
        for(int i = row_begin; i <= row_end ; i++){
            long Si = 0;
            for(int j = 0; j < data[i-1].length; j++){ //왜 i-1?
                Si += data[i-1][j] % i; //왜 i-1?
            }
            SiAccu ^= (int)Si;
        }
        
        return SiAccu;
    }
}