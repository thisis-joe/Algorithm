import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        // prices 배열을 순회하며, 아직 가격이 떨어지지 않은 인덱스를 스택에 저장
        for (int i = 0; i < n; i++) {
            // 현재 가격이 스택의 top 인덱스의 가격보다 낮다면, 
            // 그 인덱스의 가격은 현재 시점에 떨어진 것이므로 결과 계산
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                int idx = stack.pop();
                answer[idx] = i - idx;
            }
            stack.push(i);
        }
        
        // 아직 스택에 남은 인덱스는 끝까지 가격이 떨어지지 않은 경우
        while (!stack.isEmpty()) {
            int idx = stack.pop();
            answer[idx] = n - 1 - idx;
        }
        
        return answer;
    }
}
