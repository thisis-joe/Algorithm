class Solution {
    public int solution(int n) {
        int countSosu=0;
        for(int i=2;i<=n;i++){
            countSosu += isSosu(i) ? 1 : 0;
        }
        return countSosu;
    }
    public boolean isSosu(int n){
        if(n<2) return false;
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0) return false;
        }
        return true;
    }
}