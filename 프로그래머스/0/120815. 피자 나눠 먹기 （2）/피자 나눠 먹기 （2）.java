class Solution {
    public int solution(int n) {
        int k=1;
        
            while(6*k%n!=0){
                k++;
            }
        
        return k;
    }
}