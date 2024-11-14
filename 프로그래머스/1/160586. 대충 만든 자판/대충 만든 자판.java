import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        List<Integer> intList = new ArrayList<>();

        for (String target : targets) {
            int cntSum = 0;
            boolean canType = true;

            for (int i = 0; i < target.length(); i++) { // target의 각 문자에 대해
                int min = Integer.MAX_VALUE;

                for (String eachKM : keymap) {
                    for (int j = 0; j < eachKM.length(); j++) {
                        if (eachKM.charAt(j) == target.charAt(i)) {
                            min = Math.min(min, j + 1); // 최소 누름 횟수 갱신
                            break; // 같은 값을 찾았으면 다음 eachKM으로 이동
                        }
                    }
                }

                if (min == Integer.MAX_VALUE) { // 해당 문자가 keymap에 없는 경우
                    canType = false;
                    break;
                } else {
                    cntSum += min;
                }
            }

            // target을 완성할 수 없는 경우 -1 추가
            intList.add(canType ? cntSum : -1);
        }

        return intList.stream().mapToInt(i -> i).toArray();
    }
}