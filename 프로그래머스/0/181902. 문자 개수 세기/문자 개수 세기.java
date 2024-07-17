//알파벳 개수는 26개 라는 것은 알아두자.
//A는 아스키코드로 65, a는 아스키코드로 97이다. 이것을 모른다 해도 'A' 를 뺀다던지 해서 범위 파악은 가능하다.
//아스키코드에서 Z 다음 바로 a가 오지 않는다. 
class Solution {
    public int[] solution(String my_string) {
        int[] answer = new int[52];
        
        for(int i=0;i<my_string.length();i++){
            char c = my_string.charAt(i);
            if(c>='A'&&c<='Z') answer[c-'A']++;
            else if(c>='a'&&c<='z') answer[c-'a'+26]++;
        }
        return answer;
    }
}
