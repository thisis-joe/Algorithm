class Solution {
    public String solution(String s, String skip, int index) {
        char[] given = s.toCharArray();
        
        for(int i = 0 ; i < given.length ; i++){
            int move = 0;
            while(move < index){
                given[i]++;
                if(given[i] > 'z') given[i] -= 26;
                if(!skip.contains(given[i]+"")) move++;
            }
        }
        
        return new String(given);
    }
}