class Solution {
    public int solution(String myString, String pat) {
        //String은 변경불가한 객체이고, A<->B 상호치환을 위해서 char배열로 다룸. replace사용시 한번에 다 변경되는 문제가 있음
        
        char[] charArr = myString.toCharArray();
        for(int i=0;i<charArr.length;i++){
            if(charArr[i]=='A') charArr[i]='B';
            else charArr[i]='A';
        }
        
        String newString = String.valueOf(charArr);
        
        if(newString.contains(pat)) return 1;
        else return 0;
        
    }
}