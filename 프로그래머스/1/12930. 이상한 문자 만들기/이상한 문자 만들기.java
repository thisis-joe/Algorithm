class Solution {
    public String solution(String s) {
        String[] strArr = s.split(" ", -1); // 공백을 포함하여 문자열을 분리
        StringBuilder resSb = new StringBuilder();
        
        for (int i = 0; i < strArr.length; i++) {
            String str = strArr[i];
            
            // 공백이 아닌 단어일 경우 짝/홀수 인덱스에 맞춰 변환
            for (int j = 0; j < str.length(); j++) {
                resSb.append(j % 2 == 0 
                             ? Character.toUpperCase(str.charAt(j))
                             : Character.toLowerCase(str.charAt(j)));
            }
            
            // 각 단어 뒤에 공백 추가 (마지막 단어 제외)
            if (i < strArr.length - 1) {
                resSb.append(" ");
            }
        }
        
        return resSb.toString();
    }
}