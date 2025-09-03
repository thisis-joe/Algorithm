import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        // 1. 시작 시간 기준으로 정렬
        Arrays.sort(plans, (a, b) -> toMinutes(a[1]) - toMinutes(b[1]));
        
        Stack<String[]> stack = new Stack<>(); // [과제명, 남은시간]
        List<String> result = new ArrayList<>();
        
        for (int i = 0; i < plans.length; i++) {
            String name = plans[i][0];
            int start = toMinutes(plans[i][1]);
            int playtime = Integer.parseInt(plans[i][2]);
            
            // 다음 과제 시작 시간 (마지막 과제는 매우 큰 값으로 설정)
            int nextStart = (i < plans.length - 1) ? toMinutes(plans[i+1][1]) : Integer.MAX_VALUE;
            
            int end = start + playtime;
            
            if (end <= nextStart) {
                // 이번 과제 다 끝남
                result.add(name);
                int remain = nextStart - end;
                
                // 멈춘 과제 이어서 하기
                while (!stack.isEmpty() && remain > 0) {
                    String[] last = stack.pop();
                    int lastTime = Integer.parseInt(last[1]);
                    
                    if (lastTime <= remain) {
                        result.add(last[0]);
                        remain -= lastTime;
                    } else {
                        last[1] = String.valueOf(lastTime - remain);
                        stack.push(last);
                        remain = 0;
                    }
                }
            } else {
                // 이번 과제 중간에 멈춤 → 남은 시간 stack에 저장
                stack.push(new String[]{name, String.valueOf(end - nextStart)});
            }
        }
        
        // 스택에 남은 과제 처리
        while (!stack.isEmpty()) {
            result.add(stack.pop()[0]);
        }
        
        return result.toArray(new String[0]);
    }
    
    // "HH:MM" → 분 단위로 변환
    private int toMinutes(String time) {
        String[] t = time.split(":");
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }
}
