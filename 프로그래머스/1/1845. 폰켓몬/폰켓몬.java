import java.util.*;
class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for(int num:nums){
            if(hs.size()==nums.length/2){
                return nums.length/2;
            }
            else hs.add(num);
        }
        return hs.size();
    }
}
