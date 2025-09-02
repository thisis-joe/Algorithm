import java.util.*;

class Solution {
    public int solution(int[] cards) {
        boolean[] visited = new boolean[cards.length];
        List<Integer> groupSizes = new ArrayList<>();
        
        for (int i = 0; i < cards.length; i++) {
            if (!visited[i]) {
                int count = 0;
                int cur = i;
                while (!visited[cur]) {
                    visited[cur] = true;
                    cur = cards[cur] - 1; // 카드 번호 → 인덱스 변환
                    count++;
                }
                groupSizes.add(count);
            }
        }
        
        if (groupSizes.size() < 2) return 0;
        
        Collections.sort(groupSizes, Collections.reverseOrder());
        return groupSizes.get(0) * groupSizes.get(1);
    }
}
