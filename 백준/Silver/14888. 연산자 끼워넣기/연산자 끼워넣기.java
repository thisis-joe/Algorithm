import java.util.*;

public class Main {
    static int N;
    static int[] nums;
    static int[] ops = new int[4]; // + - * /
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        nums = new int[N];

        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }

        for (int i = 0; i < 4; i++) {
            ops[i] = sc.nextInt(); // + - * /
        }

        dfs(1, nums[0]); // index 1부터 시작, 앞 숫자는 이미 시작값
        System.out.println(max);
        System.out.println(min);
    }

    public static void dfs(int idx, int result) {
        if (idx == N) {
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (ops[i] > 0) {
                ops[i]--; // 사용한 연산자 감소
                int nextResult = calculate(result, nums[idx], i);
                dfs(idx + 1, nextResult);
                ops[i]++; // 백트래킹
            }
        }
    }

    public static int calculate(int a, int b, int op) {
        switch (op) {
            case 0: return a + b;      // +
            case 1: return a - b;      // -
            case 2: return a * b;      // *
            case 3: return a / b;      // /
        }
        return 0;
    }
}
