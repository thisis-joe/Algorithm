import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // 최대힙
        for (int i = 0; i < enemy.length; i++) {
            n -= enemy[i];      // 이번 라운드 병사 소모
            pq.add(enemy[i]);   // 무적권 후보에 넣기

            if (n < 0) {        // 병사 부족 → 무적권 사용
                if (k > 0) {
                    n += pq.poll(); // 가장 큰 라운드를 무적권 처리
                    k--;
                } else {
                    return i; // 더 못 막음
                }
            }
        }
        return enemy.length; // 전부 막음
    }
}
