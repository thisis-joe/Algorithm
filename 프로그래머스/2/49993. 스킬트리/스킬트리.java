import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int count = 0;

        for (String tree : skill_trees) {
            StringBuilder filtered = new StringBuilder();
            
            for (int i = 0; i < tree.length(); i++) {
                char c = tree.charAt(i);
                if (skill.indexOf(c) != -1) {
                    filtered.append(c);
                }
            }

            if (skill.startsWith(filtered.toString())) {
                count++;
            }
        }

        return count;
    }
}
