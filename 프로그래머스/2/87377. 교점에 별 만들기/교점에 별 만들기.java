import java.util.*;

class Solution {
    public String[] solution(int[][] line) {
        
        List<int[]> list = new ArrayList<>();
        int minX = Integer.MAX_VALUE, maxX = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE, maxY = Integer.MIN_VALUE;
        
        //전체교점 구해서 저장
        for(int i = 0 ; i < line.length-1 ; i++){
            int A = line[i][0], B = line[i][1], E = line[i][2];
            for(int j = i+1 ; j < line.length ; j++){
                int C = line[j][0], D = line[j][1], F = line[j][2];
                
                long numerator1 = ((long)B*F - (long)E*D);
                long numerator2 = ((long)E*C - (long)A*F);
                long denomiator  = ((long)A*D - (long)B*C);
                if( denomiator == 0 ) continue;
                if( numerator1% denomiator != 0 || numerator2% denomiator != 0) continue;
                
                int newX = (int) (numerator1 / denomiator);
                int newY = (int) (numerator2 / denomiator);

                list.add(new int[]{newX,newY}); //중복이면 어쩌지

                minX = Math.min(minX, newX);
                maxX = Math.max(maxX, newX);
                minY = Math.min(minY, newY);
                maxY = Math.max(maxY, newY);
                
                
            }
        }
        
        //그리기
        int width = maxX - minX +1; //+1해야함
        int height = maxY - minY +1;
        char[][] map = new char[height][width];
        
        for (char[] row : map) Arrays.fill(row, '.');
        
        for (int[] point : list) {
            int x = point[0];
            int y = point[1];
            int row = maxY - y;
            int col = x - minX;
            map[row][col] = '*';
        }
        
        String[] answer = new String[height];
        for (int i = 0; i < height; i++) {
            answer[i] = new String(map[i]);
        }

        return answer;
    }
}