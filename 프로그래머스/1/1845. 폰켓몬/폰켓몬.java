import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        int len = nums.length;
        
        for(int n : nums){
            set.add(n);
        }
        
        return len/2 < set.size()? len/2 : set.size();
        
    }
}