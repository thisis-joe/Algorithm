class Solution {
    public int solution(int[][] lines) {
        int[] lineCounts = new int[201]; // -100 <= a < b <= 100 이므로, 인덱스 범위는 0 ~ 200
        
        // 각 선분의 범위에 대해 겹치는 구간을 카운트합니다.
        for (int[] line : lines) {
            int start = line[0] + 100; // 음수 범위를 양수로 변환
            int end = line[1] + 100;
            
            for (int i = start; i < end; i++) {
                lineCounts[i]++;
            }
        }
        
        // 두 개 이상의 선분이 겹치는 구간의 길이를 계산합니다.
        int overlapLength = 0;
        for (int count : lineCounts) {
            if (count >= 2) {
                overlapLength++;
            }
        }
        
        return overlapLength;
    }
}