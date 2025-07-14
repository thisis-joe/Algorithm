import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  // 교환 횟수
        int pos = 1; // 공의 시작 위치는 1번 컵

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            // 만약 현재 공이 a 또는 b에 있다면, 바꿔줘야 함
            if (pos == a) pos = b;
            else if (pos == b) pos = a;
        }

        System.out.println(pos);
    }
}
