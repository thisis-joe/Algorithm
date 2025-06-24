class Solution {
    public String solution(int[] numbers, String hand) {
        String myhand = (hand.charAt(0)+"").toUpperCase();
        int[][] pos = {{3,1},{0,0},{0,1},{0,2},{1,0},{1,1},{1,2},{2,0},{2,1},{2,2}}; //0~9 위치
        String answer = "";
        int[] LPos = new int[]{3,0}; //초기손가락위치 지정!!!
        int[] RPos = new int[]{3,2};
        
        for(int num : numbers){
            if(num == 1 || num == 4 || num == 7){
                answer += "L";
                LPos[0] = pos[num][0];
                LPos[1] = pos[num][1];
            }
            else if(num == 3 || num == 6 || num == 9){
                answer += "R";
                RPos[0] = pos[num][0];
                RPos[1] = pos[num][1]; //오타 주의
            }
            else{ //2 5 8 0
                int LtoNum = getDistance(LPos,pos[num]);
                int RtoNum = getDistance(RPos,pos[num]);
                //double LtoNum = getDistance(LPos,pos[num]);
                //double RtoNum = getDistance(RPos,pos[num]);
                if(LtoNum < RtoNum){ //왼쪽 손가락과 더 가까움
                    answer += "L";
                    LPos[0] = pos[num][0];
                    LPos[1] = pos[num][1];
                }
                else if(LtoNum > RtoNum){ //오른쪽 손가락과 더 가까움
                    answer += "R";
                    RPos[0] = pos[num][0];
                    RPos[1] = pos[num][1];
                }
                else{ //거리동일 
                    answer += myhand;
                    if(myhand.equals("L")){
                        LPos[0] = pos[num][0];
                        LPos[1] = pos[num][1];
                    }
                    else{
                        RPos[0] = pos[num][0];
                        RPos[1] = pos[num][1];
                    }
                }
            }
            
        }
        return answer;
    }
    
    int getDistance(int[] pos1, int[] pos2){
        return Math.abs(pos1[0] - pos2[0]) + Math.abs(pos1[1] - pos2[1]);
    }
    // double getDistance(int[] pos1, int[] pos2){
    //     double x = Math.pow(Math.abs(pos1[0] - pos2[0]),2);
    //     double y = Math.pow(Math.abs(pos1[1] - pos2[1]),2);
    //     return Math.sqrt(x+y);
    // }
}