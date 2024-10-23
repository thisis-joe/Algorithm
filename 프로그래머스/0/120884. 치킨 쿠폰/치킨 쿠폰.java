class Solution {
    public int solution(int chicken) {
        int coupon = 0;
        int service = 0;
        for(int i=1;i<=chicken;i++){
            coupon++;
            if(coupon==10){ 
                service++;
                chicken++;
                coupon=0;
            }
        }
        return service;
    }
}