import java.util.*;
class Solution {
    public int solution(int[] wallet, int[] bill) {
        //항상 긴쪽을 접기 위해 매번 정렬 ㄱ
        //지갑의 짧은쪽보다 같거나 짧아지면 된다.
        int count = 0;
        Arrays.sort(bill);
        Arrays.sort(wallet);
        
        while(bill[1]>wallet[1] || bill[0]>wallet[0]){
            bill[1]/=2;
            Arrays.sort(bill);
            count++;
        }
        
        return count;
    }
}