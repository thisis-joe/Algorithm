import java.util.*;
class Solution {
    public long solution(String numbers) {
        //아래는 시간초과
        // numbers = numbers.replace("zero","0");
        // numbers = numbers.replace("one","1");
        // numbers = numbers.replace("two","2");
        // numbers = numbers.replace("three","3");
        // numbers = numbers.replace("four","4");
        // numbers = numbers.replace("five","5");
        // numbers = numbers.replace("six","6");
        // numbers = numbers.replace("seven","7");
        // numbers = numbers.replace("eight","8");
        // numbers = numbers.replace("nine","9");
        //아래는 시간초과 아님
        String newNumbers = numbers.replace("zero","0")
                                    .replace("one","1")
                                    .replace("two","2")
                                    .replace("three","3")
                                    .replace("four","4")
                                    .replace("five","5")
                                    .replace("six","6")
                                    .replace("seven","7")
                                    .replace("eight","8")
                                    .replace("nine","9");
        return Long.parseLong(newNumbers);
    }
}