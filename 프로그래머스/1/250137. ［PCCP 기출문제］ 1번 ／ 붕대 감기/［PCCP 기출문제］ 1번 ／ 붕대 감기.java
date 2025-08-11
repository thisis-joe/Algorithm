class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int hp = health;
        int seq = 0;
        int lastTime = attacks[attacks.length-1][0];
        
        for(int time = 1; time <= lastTime ; time ++){
            
            //공격 받는 시간인지 확인
            boolean isAttack = false;
            for(int[] attack : attacks){ //조금 비효율적?
                if(time == attack[0]){
                    hp -= attack[1];
                    seq = 0;
                    if(hp <= 0) return -1;
                    else isAttack = true;
                }
            }
            if(isAttack) continue; //공격 받았다면 붕대감기 진행하지 않음
            
            //붕대감기
            hp = hp + bandage[1] >= health ? health : hp + bandage[1];   //초당회복
            seq++;              //연속시간 증가
            if(seq == bandage[0]){
                hp = hp + bandage[2] >= health ? health : hp + bandage[2];
                seq = 0;
            }
        }
        
        return hp;
    }
}