class Solution {
    public int[] solution(String[] wallpaper) {
        //시작점 최소 i, 최소 j     ->   끝점 최대 i, 최대 j 
        
        int minI = Integer.MAX_VALUE;
        int maxI = Integer.MIN_VALUE;
        int minJ = Integer.MAX_VALUE;
        int maxJ = Integer.MIN_VALUE;
        
        for(int i = 0 ; i < wallpaper.length ; i++){
            for(int j = 0 ; j < wallpaper[i].length() ; j++){
                if(wallpaper[i].charAt(j) == '#'){
                    if(minI > i) minI = i;
                    if(maxI < i) maxI = i;
                    if(minJ > j) minJ = j;
                    if(maxJ < j) maxJ = j;
                }
            }
        }
        
        return new int[]{minI,minJ,maxI+1,maxJ+1};
    }
}