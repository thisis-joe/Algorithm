import java.util.*;

class Solution {
    public String[] solution(int[][] line) {
        List<int[]> points = new ArrayList<>();
        
        // 1. 모든 직선의 쌍에 대해 교점 찾기
        for (int i = 0; i < line.length - 1; i++) {
            for (int j = i + 1; j < line.length; j++) {
                long A = line[i][0];
                long B = line[i][1];
                long C = line[i][2];
                long D = line[j][0];
                long E = line[j][1];
                long F = line[j][2];
                
                long denominator = A * E - B * D;
                
                // 두 직선이 평행한 경우 무시
                if (denominator == 0) {
                    continue;
                }
                
                // 정수 좌표 교점 계산
                long xNumerator = B * F - C * E;
                long yNumerator = C * D - A * F;
                
                if (xNumerator % denominator == 0 && yNumerator % denominator == 0) {
                    int x = (int)(xNumerator / denominator);
                    int y = (int)(yNumerator / denominator);
                    points.add(new int[] {x, y});
                }
            }
        }

        // 2. 교점의 최소, 최대 x, y 좌표 찾기
        int minX = Integer.MAX_VALUE, maxX = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE, maxY = Integer.MIN_VALUE;
        
        for (int[] point : points) {
            minX = Math.min(minX, point[0]);
            maxX = Math.max(maxX, point[0]);
            minY = Math.min(minY, point[1]);
            maxY = Math.max(maxY, point[1]);
        }

        // 3. 격자 생성 및 초기화
        int width = maxX - minX + 1;
        int height = maxY - minY + 1;
        char[][] grid = new char[height][width];
        
        for (int i = 0; i < height; i++) {
            Arrays.fill(grid[i], '.');
        }

        // 4. 교점에 별 찍기
        for (int[] point : points) {
            int x = point[0] - minX;
            int y = maxY - point[1];
            grid[y][x] = '*';
        }

        // 5. 문자열 배열로 변환하여 반환
        String[] result = new String[height];
        for (int i = 0; i < height; i++) {
            result[i] = new String(grid[i]);
        }
        
        return result;
    }
}