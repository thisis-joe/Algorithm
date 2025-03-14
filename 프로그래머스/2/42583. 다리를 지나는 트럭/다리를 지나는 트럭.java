import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<int[]> bridgeQueue = new LinkedList<>();
        int time = 0;         
        int totalWeight = 0;  // 현재 다리 위 트럭들의 총 무게
        int index = 0;        // 다음에 다리에 들어갈 트럭의 인덱스

        while (index < truck_weights.length || !bridgeQueue.isEmpty()) {
            // 다리에서 트럭이 빠져나갈 시간에 도달한 경우 제거
            if (!bridgeQueue.isEmpty() && bridgeQueue.peek()[1] == time) {
                int[] finished = bridgeQueue.poll();
                totalWeight -= finished[0];
            }
            
            // 대기 중인 트럭이 다리에 올라갈 수 있으면 진입시킴
            if (index < truck_weights.length && totalWeight + truck_weights[index] <= weight) {
                bridgeQueue.offer(new int[]{truck_weights[index], time + bridge_length});
                totalWeight += truck_weights[index];
                index++;
                time++;  // 트럭이 올라가는 데 1초 소요
            } else {
                // 진입 불가인 경우, 다리 위에 트럭이 있다면 다음 트럭이 빠져나가는 시간으로 점프
                if (!bridgeQueue.isEmpty()) {
                    time = bridgeQueue.peek()[1];
                } else {
                    // 만약 다리가 비어있다면 1초 증가
                    time++;
                }
            }
        }
        
        return time;
    }
}
