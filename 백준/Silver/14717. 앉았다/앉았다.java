import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();

        // 카드 덱 구성: 1~10 각각 2장
        List<Integer> deck = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            deck.add(i);
            deck.add(i);
        }

        // 영학이 패 제거
        deck.remove((Integer) A);
        deck.remove((Integer) B);

        int myRank = getRank(A, B);
        int winCount = 0;
        int total = 0;

        // 상대방 패 모든 조합 시도
        for (int i = 0; i < deck.size(); i++) {
            for (int j = i + 1; j < deck.size(); j++) {
                int X = deck.get(i);
                int Y = deck.get(j);
                int oppRank = getRank(X, Y);
                if (myRank > oppRank) winCount++;
                total++;
            }
        }

        double prob = (double) winCount / total;
        System.out.printf("%.3f", prob);
    }

    // 족보 계산
    static int getRank(int a, int b) {
        if (a == b) return 100 + a; // n땡
        return (a + b) % 10;        // 끗
    }
}
