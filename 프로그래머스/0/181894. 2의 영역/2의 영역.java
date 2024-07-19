import java.util.*;

class Solution {
    public int[] solution(int[] arr) { 
       int firstIndex = -1;
        int lastIndex = -1;
        
        // Find the first occurrence of 2
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 2) {
                firstIndex = i;
                break;
            }
        }
        
        // If there is no 2 in the array, return [-1]
        if (firstIndex == -1) {
            return new int[] {-1};
        }
        
        // Find the last occurrence of 2
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == 2) {
                lastIndex = i;
                break;
            }
        }
        
        // Create the result array with the subarray from firstIndex to lastIndex
        int[] result = new int[lastIndex - firstIndex + 1];
        for (int i = firstIndex; i <= lastIndex; i++) {
            result[i - firstIndex] = arr[i];
        }
        
        return result;
    }
}