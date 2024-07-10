class Solution {
    public int solution(int a, int b) {
        String str1 = ""+a+b;
        String str2 = ""+b+a;
        
        if(Integer.valueOf(str1)>=Integer.valueOf(str2)) return Integer.valueOf(str1);
        else return Integer.valueOf(str2);
        
    }
}
