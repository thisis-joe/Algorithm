class Solution {
    public String solution(String s) {
        boolean isBlank = true;
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            if(c==' ') {
                sb.append(c);
                isBlank=true;
            }
            else if(isBlank==true && c!=' '){
                sb.append(Character.toUpperCase(c));
                isBlank=false; //1회만 변경후 다시 false로 바꿔야, 단어의 첫 글자에 대해서만 대문자가 적용
            }else{
                sb.append(Character.toLowerCase(c));
            }
        }
        return sb.toString();
    }
}