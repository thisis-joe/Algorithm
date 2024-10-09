import java.math.BigInteger;

class Solution {
    public int solution(int balls, int share) {
        BigInteger up = BigInteger.ONE;
        BigInteger down = BigInteger.ONE;
        
        // 분자 계산: balls * (balls-1) * ... * (balls-share+1)
        for (int i = 0; i < share; i++) {
            up = up.multiply(BigInteger.valueOf(balls - i));
        }
        
        // 분모 계산: share!
        for (int i = 1; i <= share; i++) {
            down = down.multiply(BigInteger.valueOf(i));
        }
        
        // 결과 = 분자 / 분모
        BigInteger result = up.divide(down);
        
        // 결과를 int로 변환 (int 범위를 넘지 않는지 주의해야 함)
        return result.intValue();
    }
}