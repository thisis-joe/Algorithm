import java.util.*;

class Solution {
    public int solution(String ineq, String eq, int n, int m) {
        String comparativeOperator = ineq + eq; 
        
        switch(comparativeOperator.toString()){
            case("<="):
                return n <= m ? 1 : 0 ;
            case(">="):
                return n >= m ? 1 : 0 ;
            case(">!"):
                return n > m ? 1 : 0 ;
            case("<!"):
                return n < m ? 1 : 0 ;
            default:
                return -1;
        }
    }
}