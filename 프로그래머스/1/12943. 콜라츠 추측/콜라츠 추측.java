class Solution {
    public int solution(int num) {
        int count = 0;
        long n = num;
        while(n != 1){
            if(count >= 500) return -1;
            if(n%2==0){
                n /= 2;
                count++;
                continue;
            }else{
                n = n*3 +1;
                count++;
                continue;
            }
        }
        
        return count;
    }
}