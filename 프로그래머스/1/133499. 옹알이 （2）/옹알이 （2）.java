class Solution {
    public int solution(String[] babblings) {
        // "aya", "ye", "woo", "ma" 4가지 발음만 가능
        int answer = 0;
        for(int i = 0; i < babblings.length; i++) {
            if(babblings[i].contains("ayaaya") || babblings[i].contains("yeye") 
               || babblings[i].contains("woowoo") || babblings[i].contains("mama")) {
                continue;
            }

            babblings[i] = babblings[i].replaceAll("aya", " ");
            babblings[i] = babblings[i].replaceAll("ye", " ");
            babblings[i] = babblings[i].replaceAll("woo", " ");
            babblings[i] = babblings[i].replaceAll("ma", " ");
            babblings[i] = babblings[i].replaceAll(" ", "");

            if(babblings[i].length()  == 0) answer++;

        }
        return answer;
    }
}