import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        String regex = "[^"+skill+"]";
        int count = 0;
        for(String ST : skill_trees){
            ST = ST.replaceAll(regex,""); //스킬트리에 없는 문자는 없애기
            if(skill.startsWith(ST)) count++;
        }
        return count;
    }
}