class Solution {
    public int solution(int a, int b) {
        //기약분수 만들기
        int numerator = a; 
        int denominator = b;
        for(int i=2;i<=Math.min(a,b);i++){
            if(numerator%i==0 && denominator%i==0) {
                numerator /= i;
                denominator /= i;
                i--;
            }
        }
                //System.out.println(numerator+" , "+denominator);
        //분모 소인수 분해 및 유한소수 판별
        for(int i=2;i<=denominator;i++){
            int flag=0;
            if(isSosu(i)==1){
                if(denominator%i==0){
                    if(i!=2 && i!=5) return 2;
                }  
            }
            else continue;
        }
        return 1;
    }
    
    //소수판별
    public int isSosu(int num){
        if(num==2){
            return 1;
        }
        else{
            for(int i=2;i<num;i++){
                if(num%i==0){
                    return 2;
                }
            }
        }
        return 1;
    }
    
}