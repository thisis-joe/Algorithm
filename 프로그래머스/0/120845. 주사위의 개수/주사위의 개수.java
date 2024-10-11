import java.util.*;

class Solution {
    public int solution(int[] box, int n) {
      int availableX = (box[0] - box[0] % n) / n;
        int availableY = (box[1] - box[1] % n) / n;
        int availableZ = (box[2] - box[2] % n) / n;

        return availableX * availableY * availableZ;
        
    }
}