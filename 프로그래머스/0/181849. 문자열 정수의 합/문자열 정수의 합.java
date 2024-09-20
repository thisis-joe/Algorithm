class Solution {
    public int solution(String num_str) {
        int sum=0;
        int len=num_str.length();
        int i=0;
        while(i<len){
            sum+=Integer.valueOf(num_str.charAt(i))-48;
            i++;
        }
        return sum;
    }
}