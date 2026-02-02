import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        // Scanner는 공백(스페이스, 탭, 엔터)을 기준으로 하나씩만 읽어옵니다.
        // 따라서 거대한 한 줄이 들어와도 메모리가 터지지 않습니다.
        Scanner sc = new Scanner(System.in);
        
        for (int test_case = 1; test_case <= 10; test_case++) {
            if (!sc.hasNextInt()) break;
            
            int N = sc.nextInt();
            List<String> codesList = new LinkedList<>();
            for (int i = 0; i < N; i++) {
                codesList.add(sc.next());
            }

            int cmdCnt = sc.nextInt();
            // 명령어 개수만큼 반복 처리
            for (int i = 0; i < cmdCnt; i++) {
                String cmd = sc.next();
                
                if (cmd.equals("I")) {
                    int x = sc.nextInt();
                    int y = sc.nextInt();
                    for (int j = 0; j < y; j++) {
                        codesList.add(x++, sc.next());
                    }
                } else if (cmd.equals("D")) {
                    int x = sc.nextInt();
                    int y = sc.nextInt();
                    for (int j = 0; j < y; j++) {
                        if (x < codesList.size()) codesList.remove(x);
                    }
                } else if (cmd.equals("A")) {
                    int y = sc.nextInt();
                    for (int j = 0; j < y; j++) {
                        codesList.add(sc.next());
                    }
                }
            }

            // 결과 출력
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(test_case);
            for (int i = 0; i < 10 && i < codesList.size(); i++) {
                sb.append(" ").append(codesList.get(i));
            }
            System.out.println(sb.toString());
        }
    }
}