import java.util.*;
class Solution {
    public String solution(String str1, String str2) {
        ArrayList<String> al1= new ArrayList<>(Arrays.asList(str1.split("")));
        ArrayList<String> al2= new ArrayList<>(Arrays.asList(str2.split("")));
        ArrayList<String> reslist = new ArrayList<>();
        for(int i=0; i<str1.length(); i++){
            reslist.add(al1.get(i)+al2.get(i));
        }
        System.out.println(reslist);
        String answer = String.join("",reslist);
        
        return answer;
    }
}