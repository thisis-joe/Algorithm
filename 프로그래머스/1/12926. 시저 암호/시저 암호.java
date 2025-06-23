class Solution {
    public String solution(String s, int n) {
        char[] charArr = s.toCharArray();
        for(int i = 0 ; i < charArr.length ; i++){
            if(charArr[i]!=' '){
                charArr[i] = Character.isUpperCase(charArr[i]) 
                            ? (char)('A' + (charArr[i] - 'A' + n) % 26) 
                            : (char)('a' + (charArr[i] - 'a' + n) % 26);
            }
        }
        return new String(charArr);
    }
}