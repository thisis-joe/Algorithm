import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next().toUpperCase(); // 대소문자 구분 안 하므로 대문자로 통일

        int[] count = new int[26]; // 알파벳 A-Z

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            count[c - 'A']++;
        }

        int max = -1;
        char result = '?';
        for (int i = 0; i < 26; i++) {
            if (count[i] > max) {
                max = count[i];
                result = (char) (i + 'A');
            } else if (count[i] == max) {
                result = '?';
            }
        }

        System.out.println(result);
    }
}