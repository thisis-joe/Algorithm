class Solution {
    public String solution(String cipher, int code) {
        String s= "";
        for(int i = 0 ; i < cipher.length() ; i++){
            if((i+1)%code==0) s+=cipher.charAt(i);
        }
        return s;
    }
}