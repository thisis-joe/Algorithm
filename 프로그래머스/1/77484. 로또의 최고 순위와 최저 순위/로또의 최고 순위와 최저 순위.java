import java.util.*;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] whatIf = new int[2];
        //중복은 없으므로 Set으로 진행해보자. Set에도 contains같은게 있었던가? 없으면 반복문 돌아야지 뭐
        Set<Integer> lottoSet = new HashSet<>();
        int cntZero = 0;
        int cntSame = 0;
        
        //Set에 값 넣기
        for(int num : lottos) {lottoSet.add(num); if(num==0) cntZero++;}
        
        //일치 확인
        for(int num : win_nums){
            if(lottoSet.contains(num)) cntSame++;
        }
        
        int best = cntSame+cntZero;
        
        whatIf[0] = best == 6 ? 1 : 
                    best == 5 ? 2 : 
                    best == 4 ? 3 : 
                    best == 3 ? 4 :
                    best == 2 ? 5 : 
                    6;
        
        whatIf[1] = cntSame == 6 ? 1 : 
                    cntSame == 5 ? 2 : 
                    cntSame == 4 ? 3 : 
                    cntSame == 3 ? 4 :
                    cntSame == 2 ? 5 : 
                    6;
        
        return whatIf;
    }
}


/*
int countZero = 0;
        String lottosStr = "";
        
        for(int num : lottos) {
            lottosStr += num+"  ";
            if(num==0) countZero++;
        }
        for(int num : win_nums){
            if(lottosStr.contains(num+"")){
                lottosStr = lottosStr.replace(num+"  ","S  ");
            }
        }
        
        System.out.println(lottosStr);
        String[] strArr = lottosStr.split("  ");
        List<String> strList = new ArrayList<>();
        for(String str : strArr) strList.add(str);
        
        int sameNumCnt = Collections.frequency(strList,"S");
        int zeroGoSame = sameNumCnt+countZero;
        
        whatIf[0] = zeroGoSame == 6 ? 1 : 
                    zeroGoSame == 5 ? 2 : 
                    zeroGoSame == 4 ? 3 : 
                    zeroGoSame == 3 ? 4 :
                    zeroGoSame == 2 ? 5 : 
                    6;
        
        whatIf[1] = sameNumCnt == 6 ? 1 : 
                    sameNumCnt == 5 ? 2 : 
                    sameNumCnt == 4 ? 3 : 
                    sameNumCnt == 3 ? 4 :
                    sameNumCnt == 2 ? 5 : 
                    6;
*/