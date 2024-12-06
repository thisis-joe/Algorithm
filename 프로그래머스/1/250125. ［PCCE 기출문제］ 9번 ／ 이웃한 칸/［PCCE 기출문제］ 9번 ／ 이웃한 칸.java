/*
1. 정수를 저장할 변수 n을 만들고 board의 길이를 저장합니다.
2. 같은 색으로 색칠된 칸의 개수를 저장할 변수 count를 만들고 0을 저장합니다.
3. h와 w의 변화량을 저장할 정수 리스트 dh, dw를 만들고 각각 [0, 1, -1, 0], [1, 0, 0, -1]을 저장합니다.
4. 반복문을 이용해 i 값을 0부터 3까지 1 씩 증가시키며 아래 작업을 반복합니다.
    4-1. 체크할 칸의 h, w 좌표를 나타내는 변수 h_check, w_check를 만들고 각각 h + dh[i], w + dw[i]를 저장합니다.
    4-2. h_check가 0 이상 n 미만이고 w_check가 0 이상 n 미만이라면 다음을 수행합니다.
        4-2-a. board[h][w]와 board[h_check][w_check]의 값이 동일하다면 count의 값을 1 증가시킵니다.
5. count의 값을 return합니다.
*/
class Solution {
    public int solution(String[][] board, int h, int w) {

        String select = board[h][w];
        int height = board.length;
        int width = board[0].length;
        int result = 0;
        int[] dh = {0,1,-1,0};
        int[] dw = {1,0,0,-1};
        
        for(int i=0;i<4;i++){
            if((h+dh[i]<0) ||
                (w+dw[i]<0) || 
                (h+dh[i]>=height ||
                (w+dw[i]>=width))){
                continue;
            }
            else{
                if(board[h+dh[i]][w+dw[i]].equals(select)) {
                    result++;
                }
            }
        }
        
        return result;
    }
}





