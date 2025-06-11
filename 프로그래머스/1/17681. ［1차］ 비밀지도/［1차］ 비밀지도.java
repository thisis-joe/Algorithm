import java.util.*;
class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] result = new String[n];
        //비트연산
        for(int i = 0 ; i < n ; i++){
            String row = Integer.toBinaryString(arr1[i] | arr2[i]);
             // n 길이만큼 앞에 0을 채워줌
            String padded = String.format("%" + n + "s", row).replace(' ', '0');
            
            String tmp = "";
            for(char c : padded.toCharArray()){
                if(c=='1') tmp += "#";
                else tmp += " ";
            }
            
            
            //자릿수 맞춰주기
            
            result[i] = tmp;
        }
        
        return result;
        
        //결과 값의 길이는 통일 -> 가장 큰 값에 맞춤
    }
}

