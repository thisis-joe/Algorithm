import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int valid = 0;
        String regex = "[^" + skill + "]"; // skill에 없는 문자 전부 제거

        for (String tree : skill_trees) {
            String reduced = tree.replaceAll(regex, ""); // 선행 스킬들만 남김
            if (skill.startsWith(reduced)) {             // 앞부분(prefix)인지 확인
                valid++;
            }
        }
        return valid;
    }
}
