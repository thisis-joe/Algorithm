import java.util.*;
class Solution {
    public String solution(String my_string, int[] indices) {
        StringBuilder sb = new StringBuilder(my_string);
        
        for(int i=0;i<indices.length;i++){
            //sb.deleteCharAt(indices[i]);// 이렇게 하면 매번 my_string의 길이가 바뀐다.
            sb.setCharAt(indices[i], ' '); // StringBuilder에서 setCharAt()을 이용해 특정 위치 문자를 변경 가능하다.
            
        }
        
        return sb.toString().replace(" ","");
    }
}