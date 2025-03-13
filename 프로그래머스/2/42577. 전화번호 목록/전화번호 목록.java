import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        //사전 순 정렬
        Arrays.sort(phone_book);
        
        //인접 원소에서 접두사 판별
        for(int i=1;i<phone_book.length;i++){
            if(phone_book[i].startsWith(phone_book[i-1])) return false;
        }
            
        //접두사가 없는 경우
        return true;
    }
}