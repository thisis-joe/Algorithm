class Solution {
    public int solution(int n) {
        return (int)(fibonacci(n));
    }
    
    long fibonacci(int num){
        long fibbA = 0;
        long fibbB = 1;
        long result = 0;
        
        for(int i=0;i<num-1;i++){
            result=(fibbA + fibbB) % 1234567;
            fibbA=fibbB;
            fibbB=result;
        }
        
        return result;
    }
    
    
    
}
