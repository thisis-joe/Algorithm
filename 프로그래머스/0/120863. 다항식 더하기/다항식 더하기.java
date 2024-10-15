import java.util.*;
class Solution {
    public String solution(String polynomial) {
        
        String[] strArr = polynomial.split(" ");
        int xCnt=0;
        int sumNum=0;
        //연산
        for(String str : strArr){
            if(str.contains("x")){
                if(str.charAt(0)=='x') xCnt++;
                else xCnt += Integer.parseInt(str.substring(0,str.indexOf("x")));
            }
            else if(!str.contains("+")) sumNum += Integer.parseInt(str);
        }        
        //출력
        if(xCnt>0 && sumNum>0){
            return xCnt == 1 ? "x + " + sumNum : xCnt + "x + " + sumNum;
        }
        else if(xCnt==0) return sumNum+"";
        else return xCnt == 1 ? "x" : xCnt+"x"; //xCnt==1 이면 1x가 아닌 x 출력!! 즉 else return xCnt + "x"; 가 아님.
        
        
    }
}









//공백양의정수공백  -> 정규표현식?