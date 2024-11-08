class Solution {
    public boolean solution(String s) {

        if(s.matches(".*[^0-9].*") || (s.length()!=4 && s.length()!=6)) return false;
        else return true;
    }
}