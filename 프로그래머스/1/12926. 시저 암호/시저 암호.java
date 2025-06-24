class Solution {
    public String solution(String s, int n) {
        char[] cArr = s.toCharArray();
        for(int i = 0 ; i < cArr.length; i++){
            if(cArr[i] == ' ') continue;
            char c = (char)(cArr[i] + n); 
            if(cArr[i] >= 'A' && cArr[i] <= 'Z'){
                cArr[i] = c > 'Z' ? (char)(c-26) : c;
            }
            else{
                cArr[i] = c > 'z' ? (char)(c-26) : c;
            }
        }
        return new String(cArr);
    }
}