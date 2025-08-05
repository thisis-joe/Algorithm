class Solution {
    public int solution(String s) {
        int answer = s.length(); // 최악의 경우는 압축 안 됐을 때
        
        // 1개 단위(step)부터 s.length()/2까지 시도
        for (int step = 1; step <= s.length() / 2; step++) {
            StringBuilder compressed = new StringBuilder();
            String prev = s.substring(0, step); // 첫 덩어리
            int count = 1;
            
            // step 단위로 순회
            for (int j = step; j < s.length(); j += step) {
                String current;
                if (j + step <= s.length()) {
                    current = s.substring(j, j + step);
                } else {
                    current = s.substring(j); // 남은 부분
                }
                
                if (prev.equals(current)) {
                    count++;
                } else {
                    if (count > 1) compressed.append(count);
                    compressed.append(prev);
                    prev = current;
                    count = 1;
                }
            }
            
            // 마지막 덩어리 처리
            if (count > 1) compressed.append(count);
            compressed.append(prev);
            
            // 최소 길이 갱신
            answer = Math.min(answer, compressed.length());
        }
        
        return answer;
    }
}
