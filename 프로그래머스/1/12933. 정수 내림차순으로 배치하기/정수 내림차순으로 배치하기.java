
import java.util.stream.Collectors;

class Solution {
    public long solution(long n) {
        // 1. 숫자를 문자열로 변환하고 각 문자를 Stream으로 처리
        String sortedStr = Long.toString(n).chars()
            // 2. 각 문자를 역순으로 정렬
            .mapToObj(c -> (char) c) 
            .sorted((a, b) -> b - a)  // 내림차순 정렬
            // 3. 문자열로 다시 합침
            .map(String::valueOf)
            .collect(Collectors.joining());

        // 4. 문자열을 숫자로 변환
        return Long.parseLong(sortedStr);
    }
}
//(Comparator.reverseOrder())