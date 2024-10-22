import java.util.*;

class Solution {
    public int[] solution(int[][] score) {
        int len = score.length;
        double[] avgScore = new double[len];
        int[] ranks = new int[len];
        
        // 각 학생의 평균 점수를 계산
        for (int i = 0; i < len; i++) {
            avgScore[i] = (score[i][0] + score[i][1]) / 2.0;
        }
        
        // 순위를 매기기 위해, 평균 점수와 인덱스를 함께 저장하는 배열 생성
        Integer[] indices = new Integer[len];
        for (int i = 0; i < len; i++) {
            indices[i] = i;
        }

        // 평균 점수를 기준으로 내림차순 정렬, 같으면 그대로 순서 유지
        Arrays.sort(indices, (a, b) -> Double.compare(avgScore[b], avgScore[a]));

        // 등수를 계산하고 공동 순위 처리
        int[] rankArr = new int[len];
        int rank = 1;
        for (int i = 0; i < len; i++) {
            if (i > 0 && avgScore[indices[i]] == avgScore[indices[i - 1]]) {
                rankArr[indices[i]] = rankArr[indices[i - 1]]; // 공동 순위
            } else {
                rankArr[indices[i]] = rank; // 새로운 순위
            }
            rank++;
        }
        
        return rankArr;
    }
}