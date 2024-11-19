import java.util.*;
class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] resmap = new String[n];
        Arrays.fill(resmap,"");
        
        for(int i=0;i<n;i++){
            String row4map1 = String.format("%"+n+"s",Integer.toBinaryString(arr1[i])).replace(' ','0');   
            String row4map2 = String.format("%"+n+"s",Integer.toBinaryString(arr2[i])).replace(' ','0');   
            
            for(int j=0;j<n;j++){ //row4map1의 길이까지 이지만 어차피 그게 n이다
                if(row4map1.charAt(j)=='0'&& row4map2.charAt(j)=='0') resmap[i]+=" ";
                else resmap[i]+="#";
            }
        }
        
        return resmap;
        
    }
}