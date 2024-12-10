import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        
        int extColumn = -1; 
        int newDataCnt = 0; 
        int sortColumn = -1;
        
        switch(ext){
            case "code"     : extColumn = 0; break;
            case "date"     : extColumn = 1; break;
            case "maximum"  : extColumn = 2; break;
            case "remain"   : extColumn = 3; break;
        }
        switch(sort_by){
            case "code"     : sortColumn = 0; break;
            case "date"     : sortColumn = 1; break;
            case "maximum"  : sortColumn = 2; break;
            case "remain"   : sortColumn = 3; break;
        }
        
        final int sortColumnF = sortColumn;
        
        for(int[] ele : data) {
            if(ele[extColumn]<val_ext) newDataCnt++;
        }
        
        int[][] newData = new int[newDataCnt][4];
        int idx = 0;
        
        for(int i=0; i<data.length; i++){
            if(data[i][extColumn]<val_ext){
                for(int j=0;j<4;j++){
                    newData[idx][j]=data[i][j];
                }
                idx++;
            } 
        }
        
        Arrays.sort(newData, (o1,o2) -> {return o1[sortColumnF] - o2[sortColumnF];});
        
        return newData;
    }
}