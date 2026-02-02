import java.util.*;
import java.io.*;
 
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        for (int test_case = 1; test_case <= 10; test_case++) {
            if (!sc.hasNextInt()) break;
             
            int N = sc.nextInt();
            List<String> codesList = new LinkedList<>();
            for (int i = 0; i < N; i++) {
                codesList.add(sc.next());
            }
 
            int cmdCnt = sc.nextInt();
            for (int i = 0; i < cmdCnt; i++) {
                String cmd = sc.next();
                 
                if (cmd.equals("I")) {
                    int x = sc.nextInt();
                    int y = sc.nextInt();
                    for (int j = 0; j < y; j++) {
                        codesList.add(x++, sc.next());
                    }
                } 
            }
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(test_case);
            for (int i = 0; i < 10 && i < codesList.size(); i++) {
                sb.append(" ").append(codesList.get(i));
            }
            System.out.println(sb.toString());
        }
    }
}