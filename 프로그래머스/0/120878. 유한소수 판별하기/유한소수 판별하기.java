class Solution {
    public int solution(int a, int b) {
        int answer = ((a*320000)%b == 0) ? 1 : 2;
        return answer;
    }
}
