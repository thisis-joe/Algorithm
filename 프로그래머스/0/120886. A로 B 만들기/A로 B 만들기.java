class Solution {
    public int solution(String before, String after) {
        for(char c : before.toCharArray()){
            if(after.contains(c+"")){
                after=after.replaceFirst(c+"","1");
            }
            else{
                return 0;
            }
        }
        if(after.contains("^[1]")) return 0;
        else return 1;
        
    }
}