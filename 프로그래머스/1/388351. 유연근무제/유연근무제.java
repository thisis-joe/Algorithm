import java.util.*;

class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int[][] dead = new int[schedules.length][2];
        int[] deadline = new int[schedules.length];
        int result = 0;
        
        //데드라인 결정
        for(int i = 0 ; i < schedules.length ; i++){
            dead[i][0] = schedules[i]/100;
            dead[i][1] = schedules[i]%100+10;
            if(schedules[i]%100+10 >= 60){
                dead[i][0] += 1;
                dead[i][1] -= 60;
            }
            deadline[i] = dead[i][0] * 60 + dead[i][1];
        }
        
        //i = 사람 
        for(int i = 0 ; i < timelogs.length; i++){
            int successCnt = 0;
            int day = startday;
            for(int log : timelogs[i]){
                if(day>=1 && day<=5){
                    int h = log/100;
                    int m = log%100;
                    int time = h * 60 + m;
                    if(deadline[i] >= time){
                        successCnt++;
                        System.out.println("OK  : "+deadline[i]+" : "+time);
                    }
                    else{
                        System.out.println("LATE: "+deadline[i]+" : "+time);
                    }
                }
                else{
                    System.out.println("DAY : " + day);
                }
                day++;
                if(day > 7){
                    day = 1;
                }
            }
            System.out.println("---");
            if(successCnt >= 5){
                result++;                
            }
        }
        return result;
    }
}