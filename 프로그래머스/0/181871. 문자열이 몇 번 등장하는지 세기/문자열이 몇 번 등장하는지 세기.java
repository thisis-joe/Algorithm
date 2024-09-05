class Solution {
    public int solution(String myString, String pat) {
        int cnt = 0;
        // 루프 조건을 <= myString.length() - pat.length()로 변경하여 불필요한 호출 감소
        for (int i = 0; i <= myString.length() - pat.length(); i++) {
            // startsWith를 사용하여 i번째 위치에서 시작하는지 확인
            if (myString.startsWith(pat, i)) {
                cnt++;
            }
        }
        return cnt;
    }
}