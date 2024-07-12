import java.util.*;

class Solution {
    public int[] solution(int l, int r) {
        List<Integer> arrlist = new ArrayList<>();

        for(int i = l; i <= r; i++){
            String str = i+"";
            int cnt = 0;
            
            for(int j = 0; j < str.length(); j++){
                if(str.charAt(j)=='5' || str.charAt(j)=='0') {
                    cnt++;
                }
            }
            
            if(cnt == str.length()) {
                cnt = 0;
                arrlist.add(i); //list는 add
                continue;
            }
        }
        
        if(arrlist.size() == 0) { //arraylist의 길이를 구할 떈 size
            int[] nothing = {-1};
            return nothing;
            // -1 한개로 이루어진 정수 배열을 반환 하는 다른 방법이 있나요?
        }
        
        return arrlist.stream().mapToInt(i->i).toArray(); //arraylist를 int배열로 변환. (일단 외우고 stream공부하자 )
    }
}