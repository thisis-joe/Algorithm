import java.util.*;
class Solution {
    public int solution(int[] arr) {
        boolean flag = true;
        int[] temparr = Arrays.copyOf(arr,arr.length);
        int len = arr.length;
        //x는 1회부터 시작, 최대 MAX까지 시행
        for(int x=0 ; x<=Integer.MAX_VALUE ; x++){
            flag=true;
            for(int i=0;i<len;i++){
                if(temparr[i]>=50 && temparr[i]%2==0) temparr[i]/=2;
                else if(temparr[i]<50 && temparr[i]%2!=0) temparr[i]=temparr[i]*2+1;
                
                if(temparr[i] != arr[i]) {
                    flag=false;
                }
            }
            //비교를 위한 배열에 기존 배열 정보 저장
            arr=Arrays.copyOf(temparr,temparr.length);
            if(flag) return x;
        }
       return -1;
    }
}