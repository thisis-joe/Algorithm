class Solution {
    public int solution(int n, int w, int num) {
        int layer = (num - 1) / w;      // num이 위치한 층(아래=0)
        int pos = (num - 1) % w;        // 그 층에서의 위치(0-based)

        // 지그재그 배치에 따른 '열' 계산
        int col = (layer % 2 == 0) ? pos : (w - 1 - pos);

        int top = (n - 1) / w;          // 최상층 인덱스
        int rem = n % w;                 // 최상층 실제 박스 수 (0이면 가득 참)

        // 우선, 본인 포함해서 위로 쌓인 층 수
        int need = top - layer + 1;

        // 최상층이 덜 차 있으면, 그 열에 박스가 있는지 확인해 하나 줄일 수 있음
        if (rem != 0) {
            boolean topHasCol;
            if (top % 2 == 0) {
                // 최상층이 짝수층(왼→오): 채워진 열은 [0, rem-1]
                topHasCol = (col < rem);
            } else {
                // 최상층이 홀수층(오→왼): 채워진 열은 [w-rem, w-1]
                topHasCol = (col >= w - rem);
            }
            if (!topHasCol) need--;  // 그 열 위 맨 꼭대기에 박스가 없으면 하나 덜 꺼냄
        }

        return need;
    }
}
