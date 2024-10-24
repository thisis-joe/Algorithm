import java.util.*;
class Solution {
    public int[] solution(int num, int total) {
        for(int number=-1000; number<total; number++){
            int sum=0;
            List<Integer> resList = new ArrayList<>();
            if(num==1) return new int[]{total};
            for(int seq=number; seq<num+number; seq++){
                sum+=seq;
                resList.add(seq);
            }
            if(sum==total) return resList.stream().mapToInt(i->i).toArray();
            else continue;
        }
        return new int[]{};
    }
}