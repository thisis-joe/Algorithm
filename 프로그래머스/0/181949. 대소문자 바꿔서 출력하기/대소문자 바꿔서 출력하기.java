import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        StringBuilder result = new StringBuilder(); //StringBuilder로 변환해야 문자열 변환 가능.
        
        for (char c : a.toCharArray()) {
            if (Character.isUpperCase(c)) {
                c = Character.toLowerCase(c);
            } else if (Character.isLowerCase(c)) {
                c = Character.toUpperCase(c);
            }
            result.append(c);
        }
        System.out.println(result);
    }
}