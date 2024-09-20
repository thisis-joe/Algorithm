import java.util.*;

class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        //맵 선언법
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<rank.length;i++){
            if(attendance[i]) map.put(rank[i],i); //등수와, 학생번호를 동시에 저장
        }
        // 등수를 기준으로 오름차순 정렬
        List<Integer> sortedRanks = new ArrayList<>(map.keySet());
        Collections.sort(sortedRanks);  // 등수(rank)를 기준으로 정렬

        int a = map.get(sortedRanks.get(0));
        int b = map.get(sortedRanks.get(1));
        int c = map.get(sortedRanks.get(2));
        System.out.println(a+" "+b+" "+c);
        
        return 10000*a + 100*b + c;
    }
}