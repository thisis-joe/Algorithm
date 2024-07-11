import java.util.*;
class Solution {
    public int solution(int n, String control) {
        
        for(char c : control.toCharArray()){ //String을 for each로 접근하기 위해서는 toCharArray() 사용 해서 char 배열로 변경해야 함
            switch(c){
                case 'w':
                    n += 1; break;
                case 's':
                    n -= 1; break;
                case 'd':
                    n += 10; break;
                case 'a':
                    n -= 10; break;
            }
        }
        
        return n;
    }
}