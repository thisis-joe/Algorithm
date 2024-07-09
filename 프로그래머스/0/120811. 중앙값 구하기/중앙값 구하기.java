//array길이가 홀수이므로, 오름차순 정렬 후 중간 원소를 뽑으면 완료.
import java.util.*;
class Solution {
    public int solution(int[] array) {
        Arrays.sort(array);
        return array[array.length/2];
    }
}
