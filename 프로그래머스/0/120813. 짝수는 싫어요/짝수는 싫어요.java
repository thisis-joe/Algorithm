import java.util.*;
class Solution {
    public int[] solution(int n) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        for(int i=0;i<=n;i++){
            if(i%2!=0){
                arrayList.add(i);
            }
        }
        // ArrayList를 int[]로 변환
        int[] arr = new int[arrayList.size()];
        for(int i = 0; i < arrayList.size(); i++) {
            arr[i] = arrayList.get(i);
        }

        return arr;

    }
}