import java.util.*;
class Solution {
    public int[] solution(int n) {
        List<Integer> sosuList = new ArrayList<>();
        List<Integer> resList = new ArrayList<>();
        //n이하 소수 찾기
        sosuList.add(2);
        for(int i=3;i<=n;i++){
            for(int j=2;j<i;j++){
                if(i%j==0) break;
                if(j==i-1) sosuList.add(i);
            }
        }
        
        //소인수 찾기
        int[] sosuArr = sosuList.stream().mapToInt(i->i).toArray();
        Arrays.sort(sosuArr);
        for(int i=sosuArr.length-1;i>=0;i--){
            if(n%sosuArr[i]==0) {
                resList.add(sosuArr[i]);
                n/=sosuArr[i];
                i++;
            }
            
        }
        
        //정렬 및 중복값 제거
        int[] resArr = resList.stream().mapToInt(i->i).toArray();
        Arrays.sort(resArr);
        return Arrays.stream(resArr).distinct().toArray();
        
        
    }
    
}