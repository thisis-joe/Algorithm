import java.util.*;

class Solution {
    public int solution(int a, int b, int c, int d) {
        int answer = 0;
        int[] arr = {a,b,c,d}; //값의 순서가 중요하지 않으므로 배열에 넣어 정렬을 이용하면 간편하게 해결 가능
        Arrays.sort(arr); //정렬방법은 배열이름.sort()가 아니라 Arrays.sort(배열이름); 이다
        a=arr[0]; b=arr[1]; c=arr[2]; d=arr[3]; //정렬한 뒤 재정의
        
        return
            a==d ? 1111*a :
            a==c ? (int)Math.pow(10*a+d,2) : //제곱. pow 할땐 몇 제곱할건지 지정
            (a!=b && b==d) ? (int)Math.pow(10*b+a,2) :
            a==b && b!=c && c==d ? (a+c) * Math.abs(a-c) :
            (a==b && c!=d) ? c*d :
            (a!=b && c==d) ? a*b :
            (a!=b && c!=d && b==c) ? a*d :
            (a!=b && b!=c && c!=d && a!=d && a!=c && b!=d) ? a : 0 ;
        
    }
}