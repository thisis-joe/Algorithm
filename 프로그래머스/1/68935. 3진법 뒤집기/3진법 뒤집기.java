class Solution {
    public int solution(int n) {
        // 3진법 변환 후 뒤집기
        StringBuilder ternary = new StringBuilder();
        while (n > 0) {
            ternary.append(n % 3);
            n /= 3;
        }

        // 10진법으로 변환
        return Integer.parseInt(ternary.toString(), 3);
    }
}