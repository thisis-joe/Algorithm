import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        
        List<int[]> resList = new ArrayList<>();
        String[] columns = new String[]{"code","date","maximum","remain"};
        int extCol = -1;
        int sortCol = -1;
            
        for(int i=0;i<columns.length;i++){
            if(columns[i].equals(ext)) extCol = i;
            if(columns[i].equals(sort_by)) sortCol = i;
        }
        final int sortF = sortCol;
        
        for(int[] element : data){
            if(element[extCol]<val_ext) resList.add(element);
        }
        
        Collections.sort(resList,(o1,o2)->{
           return o1[sortF]-o2[sortF];
        });
        
        //List<int[]> to int[][]
        return resList.toArray(int[][]::new);
    }
}