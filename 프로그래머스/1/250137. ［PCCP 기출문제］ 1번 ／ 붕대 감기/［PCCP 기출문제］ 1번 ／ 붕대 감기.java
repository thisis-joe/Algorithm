import java.util.*;

class Solution {
    
    public int solution(int[] bandage, int health, int[][] attacks) {
        int hp = health;
        int lastAttackTime = attacks[attacks.length-1][0];
        int attackCount = attacks.length;
        int attackIdx = 0;
        int bandContinue = 0;
        
            
        for(int time = 0 ; time <= lastAttackTime ; time++){            
            //공격 처리
            if(time == attacks[attackIdx][0]){
                //피해
                int damage = attacks[attackIdx][1];    
                if(hp - damage <= 0){ //사망
                    return -1;
                }
                else{
                    hp -= damage;
                    attackIdx++;
                }
                
                //공격 당하는 시점에서는 기술연속시간 초기화 및 기술 사용 불가
                bandContinue = 0;
                continue; 
            }
            //공격받지 않을때 붕대 기술
            else{
                if(hp >= health){
                    bandContinue++;
                    continue; 
                }
                else{
                    bandContinue++;
                    //회복
                    if(hp + bandage[1] <= health){
                        hp += bandage[1];
                    }
                    else if(hp + bandage[1] > health){
                        hp = health;
                    }

                    //초과회복
                    if(bandContinue == bandage[0] && hp + bandage[2] <= health){
                        hp += bandage[2];
                        bandContinue = 0;
                    }
                    else if(bandContinue == bandage[0] && hp + bandage[2] > health){
                        hp = health; 
                        bandContinue = 0;
                    }
                }    
            }
            
        }
        
        return hp;
    }
}