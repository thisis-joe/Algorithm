class Solution {
    
    public int solution(int[] bandage, int health, int[][] attacks) {
        int hp = health;
        int bandDone = bandage[0];
        int band1sec = bandage[1];
        int bandOver = bandage[2];
        int bandCount = 0;
        int endTime = attacks[attacks.length-1][0];
        for(int time = 0 ; time <= endTime; time++){
            boolean isAttack = false;
            
            //해당 공격 시각에서 공격.
            for(int[] attack : attacks){
                if(attack[0] == time){
                    bandCount = 0; // 공격을 받으면 연속 붕대감기 초기화
                    isAttack = true; // 공격시간에 붕대를 감지 못하도록 공격중임을 명시
                    if(hp - attack[1] <= 0) {
                        return -1; // 이번 공격에서 사망
                    }
                    else {
                        hp -= attack[1];
                        break; 
                    }
                }
            }   
            
            //공격시간에는 붕대를 감지 못함.
            //죽지 않으면 1초마다 붕대는 감고있다.
            if(isAttack == false){
                bandCount++;
                if(bandCount == bandDone){
                    bandCount = 0;
                    int heal = band1sec + bandOver;
                    hp = hp + heal <= health ? hp + heal : health;
                }else{
                    int heal = band1sec;
                    hp = hp + heal <= health ? hp + heal : health;
                }
            }
            
        }
        
        return hp;
    }
}