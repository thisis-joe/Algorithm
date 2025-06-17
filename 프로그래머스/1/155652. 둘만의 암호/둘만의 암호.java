 class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        //skip을 알파벳에서 없애고 시작하기.
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String[] delete = skip.split("");

        for(String d:delete)
            alphabet = alphabet.replace(d,"");

        String[] myalphabet = alphabet.split("");
        String[] sArr = s.split("");

        for(int i = 0; i< sArr.length; i++){
            for(int j = 0; j < myalphabet.length; j++){
                if(sArr[i].equals(myalphabet[j])){
                    answer+=myalphabet[(j+index)%myalphabet.length];
                    continue;
                }
            }
        }

        return answer;
    }
 }
