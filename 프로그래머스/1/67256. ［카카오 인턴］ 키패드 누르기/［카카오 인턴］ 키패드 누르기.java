import java.util.*;
class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        int curPosL=10;
        int curPosR=12;
        for(int num :numbers){
            if(num==0) num=11;
            if(num ==1 || num ==4 || num == 7){
                sb.append("L");
                curPosL=num;
            }
            else if(num ==3 || num ==6 || num == 9){
                sb.append("R");
                curPosR=num;
            }
            else{
                int lenL = Math.abs(curPosL-num)%3+Math.abs(curPosL-num)/3;
                int lenR = Math.abs(curPosR-num)%3+Math.abs(curPosR-num)/3;
                if(lenR<lenL) {
                    sb.append("R");
                    curPosR=num;
                }
                else if(lenL<lenR) {
                    sb.append("L");
                    curPosL=num;
                }
                else {
                    if(hand.equals("right")){
                        sb.append("R");
                        curPosR=num;
                    }
                    else{
                        sb.append("L");
                        curPosL=num;
                    }
                }
            }
        }
        return sb.toString();
    }
}