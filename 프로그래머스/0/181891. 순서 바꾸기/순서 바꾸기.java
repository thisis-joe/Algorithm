import java.util.*;
class Solution {
    public int[] solution(int[] num_list, int n) {
        //리스트 정의
        List<Integer> intList = new ArrayList<>();
        List<Integer> numList = new ArrayList<>();
        
        //반복문으로 int 배열을 리스트로 변환하여 다룸. -> int배열의 경우 Arrays.asList(리스트); 로 불가함.
        for(int i=0;i<num_list.length;i++){
            numList.add(num_list[i]);
        }
        
        for(int i=0;i<n;i++){
            //n번재까지는, 정의한 리스트에 add (항상 리스트의 첫번째 원소를 추가)
            intList.add(numList.get(0));
            //주어진 리스트에는 앞쪽에 하나씩 제거함. (항상 첫번째 원소를 제거) 
            numList.remove(0);
        }
        
        //리스트 두개 합쳐서 반환하며, 
        numList.addAll(intList);
        return numList.stream()
                .mapToInt(i -> i)
                .toArray();
    }
}

