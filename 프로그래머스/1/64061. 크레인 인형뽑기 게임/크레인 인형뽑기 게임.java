//문제풀기 전
/* 예상풀이 
    가로형태로 주어지는 애들을 세로 스택으로 만들자. 스택을 몇개 만들어야 할까 -> 보드 개수마다 다른데 어떻게 미리 스택 개수를 알고 만들어 둘 수 있단 말인가  
    그럼 굳이 스택으로 바꿀필요 없단건가
    
*/
/* 의문점
    
*/
//문제 풀면서
/* 실패 분석 및 개선
    - 실패했다면, 무슨 이유로?
    - 시간 초과? → 어디서 느렸는지
    - 틀렸다면? → 어떤 예외 케이스를 놓쳤는지
    - **ex) “**처음에 이렇게 했다가 XX 예외 때문에 실패함”
    - 성공했다면, 문제를 어떻게 해결했는지?
    - 계속 실패한다면, 어떤 부분에서 실패한다고 생각하는지?
*/
import java.util.*;
class Solution {
    
    public int solution(int[][] board, int[] moves) {        
        int n = board.length;
        Stack<Integer>[] stacks = new Stack[n];  // 열 수만큼 스택 생성

        for (int i = 0; i < n; i++) {
            stacks[i] = new Stack<>();
            for (int j = n - 1; j >= 0; j--) {
                if (board[j][i] != 0) {
                    stacks[i].push(board[j][i]);
                }
            }
        }
        
        Stack<Integer> basket = new Stack<>(); 
        int count = 0;
        
        for (int move : moves) {
            Stack<Integer> stack = stacks[move - 1];
            if (!stack.isEmpty()) {
                int doll = stack.pop();
                if (!basket.isEmpty() && basket.peek() == doll) {
                    basket.pop();
                    count += 2;
                } else {
                    basket.push(doll);
                }
            }
        }
        
        
        return count;
    }
}