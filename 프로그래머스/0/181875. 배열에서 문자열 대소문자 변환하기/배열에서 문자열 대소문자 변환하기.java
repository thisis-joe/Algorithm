class Solution {
    public String[] solution(String[] strArr) {
        // 주어진 문자열 배열을 순회하며 인덱스에 따라 변환
        for (int i = 0; i < strArr.length; i++) {
            // 인덱스가 짝수일 때는 소문자로 변환
            if (i % 2 == 0) {
                strArr[i] = strArr[i].toLowerCase();
            } 
            // 인덱스가 홀수일 때는 대문자로 변환
            else {
                strArr[i] = strArr[i].toUpperCase();
            }
        }
        return strArr; // 변환된 배열 반환
    }
}