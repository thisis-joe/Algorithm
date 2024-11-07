class Solution {
    public long solution(long n) {
        for(int i=1;i<=n;i++){
            if((long)Math.pow(i,2)==n) return (long)Math.pow(i+1,2);
        }
        return -1;
    }
}