import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        int len = nums.length;
        
        for(int n : nums){
            set.add(n);
        }
        if(len/2 < set.size()) {
            return len/2;
        }
        else{
            return set.size();
        }
        
        
    }
}