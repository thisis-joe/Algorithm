import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            System.out.println(lastNonZeroDigit(n));
        }
    }

    // n! 의 맨 끝 0이 아닌 숫자 구하기
    static int lastNonZeroDigit(int n) {
        long result = 1;

        for (int i = 2; i <= n; i++) {
            result *= i;

            // 0 제거
            while (result % 10 == 0) {
                result /= 10;
            }

            // 오버플로우 방지 (뒤에 몇자리만 유지)
            result %= 100000; 
        }

        return (int)(result % 10); // 마지막 자리
    }
}
