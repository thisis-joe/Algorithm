class Solution {
    public int solution(int[] number) {
        return countTriplets(number, 0, 0, 0);
    }

    private int countTriplets(int[] number, int index, int selectedCount, int sum) {
        // 종료 조건: 세 개를 선택한 경우
        if (selectedCount == 3) {
            // 합이 0이라면 1을 반환하고, 아니라면 0을 반환
            return sum == 0 ? 1 : 0;
        }
        
        // 재귀 종료 조건: 배열 끝까지 탐색했는데 3개를 선택하지 못한 경우
        if (index == number.length) {
            return 0;
        }
        
        // 현재 index의 숫자를 선택하는 경우와 선택하지 않는 경우로 나누어 재귀 호출
        int include = countTriplets(number, index + 1, selectedCount + 1, sum + number[index]);
        int exclude = countTriplets(number, index + 1, selectedCount, sum);
        
        // 두 경우의 합을 반환
        return include + exclude;
    }
}