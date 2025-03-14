import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        int cnt = 0;
        
        for(int i = 0; i < progresses.length; i++ ){
            queue.add((int)Math.ceil((100.0-progresses[i])/speeds[i]));    
        }
        
        while (!queue.isEmpty()) {
            int current = queue.poll(); // 현재 배포 기준이 되는 기능의 완료 일수
            int count = 1;
            
            // 현재 기능과 함께 배포될 기능 개수 확인
            while (!queue.isEmpty() && queue.peek() <= current) {
                queue.poll();
                count++;
            }
            
            result.add(count);
        }
        
        // List를 int 배열로 변환하여 반환
        return result.stream().mapToInt(i -> i).toArray();
        
        
    }
}