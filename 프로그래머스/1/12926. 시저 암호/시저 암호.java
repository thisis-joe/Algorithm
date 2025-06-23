class Solution {
    public String solution(String s, int n) {
        char[] charArr = s.toCharArray();
        for(int i = 0 ; i < charArr.length ; i++){
            //공백
            if(charArr[i]==' '){
                continue;
            }
            //대문자 범위 벗어나는 경우
            else if(charArr[i] >= 'A' 
               && charArr[i] <= 'Z'
               && (char)((int)charArr[i] + n) > 'Z'){
                charArr[i] = (char)((int)charArr[i]+n-26);
            }
            //소문자 범위 벗어나는 경우
            else if(charArr[i] >= 'a' 
               && charArr[i] <= 'z'
               && (char)((int)charArr[i] + n) > 'z'){
                charArr[i] = (char)((int)charArr[i]+n-26);
            }   
            else{
                charArr[i] = (char)((int)charArr[i]+n);
            }
        }
        return new String(charArr);
    }
}