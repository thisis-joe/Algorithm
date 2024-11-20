import java.util.*;
class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String,Integer> score = new HashMap<>();
        int[] photoSum = new int[photo.length];
        
        //이름과 점수를 매칭
        for(int i=0;i<name.length;i++){
            score.put(name[i],yearning[i]);
        }
        
        //사진별 점수 합산
        int idx = 0;
        for(String[] curphoto : photo){
            for(String curname : curphoto){
                //photoSum[idx]+=score.get(curname); //curname이 없는 경우 nullpointexception발생
                photoSum[idx]+=score.getOrDefault(curname,0);
            }
            idx++;
        }
        
        return photoSum;
    }
}





