import java.util.*;

class Solution {
    public int solution(String s) {
        int n = s.length();
        if (n == 1) return 1; // 길이 1은 압축 불가

        int len = n;          // 최소 길이(초기값: 원본 길이)
        int size = 1;         // 1 단위부터 시작

        while (size <= n / 2) {             // n/2 단위까지 포함
            int start = 0;                   // 매 size마다 포인터 초기화
            int end = size;

            StringBuilder result = new StringBuilder();

            String prev = s.substring(start, end); // 첫 덩어리
            int cnt = 1;

            // 다음 덩어리가 "완전한 size 길이"일 때만 비교
            while (end + size <= n) {       // <= 로 완전 덩어리 비교 보장
                start += size;
                end += size;
                String next = s.substring(start, end);

                if (prev.equals(next)) {
                    cnt++;
                } else {
                    if (cnt > 1) result.append(cnt);
                    result.append(prev);     // cnt==1이어도 prev는 항상 붙임
                    prev = next;
                    cnt = 1;                 // 새 그룹 시작
                }
            }

            // 마지막 그룹 플러시(반드시 필요)
            if (cnt > 1) result.append(cnt);
            result.append(prev);

            // 남은 꼬리(완전 덩어리로 못 자른 부분) 붙이기
            if (end < n) result.append(s.substring(end));

            len = Math.min(len, result.length());
            size++;
        }
        return len;
    }
}
