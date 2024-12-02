import java.util.*;
class Solution {
    public int solution(String dartResult) {
        int[] scores = new int[4]; //스타상은 무조건 왼쪽 두개에 대해 다룰 수 있도록 한다.
        int idx=0;
        for(int i=0;i<dartResult.length();i++){ //idx는 scores만을 위한 사용할 변수이다.
            char nowChar=dartResult.charAt(i);
            //점수 처리
            if(nowChar=='1' && dartResult.charAt(i+1)=='0'){ //10인 경우
                idx++; 
                scores[idx]=10;
                i++;
            }
            else if(nowChar-'0'>=0 && nowChar-'0'<=9){
                idx++;
                scores[idx]=nowChar-'0';
            }
            //보너스 처리
            else if(nowChar=='D'){
                scores[idx]=(int)Math.pow(scores[idx],2);
            }
            else if(nowChar=='T'){
                scores[idx]=(int)Math.pow(scores[idx],3);
            }
            //옵션 처리
            else if(nowChar=='*'){
                scores[idx]*=2;
                if(idx>1) scores[idx-1]*=2;
            }
            else if(nowChar=='#'){
                scores[idx]*=-1;
            }
        }
        
        return scores[1]+scores[2]+scores[3];
    }
}