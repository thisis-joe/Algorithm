import java.util.*;

public class Main {
    static List<Integer> triangleNumbers = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 삼각수 미리 구하기 (최대 1000까지)
        for (int n = 1; n * (n + 1) / 2 <= 1000; n++) {
            triangleNumbers.add(n * (n + 1) / 2);
        }

        int T = sc.nextInt();
        while (T-- > 0) {
            int K = sc.nextInt();
            boolean found = false;

            for (int i = 0; i < triangleNumbers.size(); i++) {
                for (int j = 0; j < triangleNumbers.size(); j++) {
                    for (int k = 0; k < triangleNumbers.size(); k++) {
                        int sum = triangleNumbers.get(i) + triangleNumbers.get(j) + triangleNumbers.get(k);
                        if (sum == K) {
                            found = true;
                            break;
                        }
                    }
                    if (found) break;
                }
                if (found) break;
            }

            System.out.println(found ? 1 : 0);
        }
    }
}