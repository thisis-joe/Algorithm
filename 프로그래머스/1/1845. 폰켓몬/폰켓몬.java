import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int num = nums.length/2;
        int cnt = 0;
        
        Set<Integer> intSet = new HashSet<>();
        for(int i : nums){
            intSet.add(i);
        }
        
        return intSet.size() >= num ? num : intSet.size();
    }
}