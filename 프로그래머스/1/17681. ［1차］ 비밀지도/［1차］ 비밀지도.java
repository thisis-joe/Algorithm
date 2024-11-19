import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] resMap = new String[n];

        for (int i = 0; i < n; i++) {
            // 이진수 변환 및 길이 n 맞추기
            String binary1 = String.format("%" + n + "s", Integer.toBinaryString(arr1[i])).replace(' ', '0');
            String binary2 = String.format("%" + n + "s", Integer.toBinaryString(arr2[i])).replace(' ', '0');
            
            // 두 지도의 한 행 합치기
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (binary1.charAt(j) == '1' || binary2.charAt(j) == '1') {
                    row.append("#");
                } else {
                    row.append(" ");
                }
            }
            resMap[i] = row.toString();
        }

        return resMap;
    }
}