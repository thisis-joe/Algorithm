import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        // 중복 제거
        Set<String> reportSet = new HashSet<>(Arrays.asList(report));
        
        // 신고당한 횟수
        Map<String, Integer> reportedCnt = new HashMap<>();
        // 누가 누구를 신고했는지
        Map<String, Set<String>> reporterMap = new HashMap<>();

        // 초기화
        for (String id : id_list) {
            reportedCnt.put(id, 0);
            reporterMap.put(id, new HashSet<>());
        }

        // 신고 처리
        for (String rep : reportSet) {
            String[] parts = rep.split(" ");
            String reporter = parts[0];
            String reported = parts[1];

            if (reporterMap.get(reporter).add(reported)) {
                // 신고 대상자 신고 횟수 +1
                reportedCnt.put(reported, reportedCnt.get(reported) + 1);
            }
        }

        // 정지 대상자 추출
        Set<String> bannedUsers = new HashSet<>();
        for (String user : reportedCnt.keySet()) {
            if (reportedCnt.get(user) >= k) {
                bannedUsers.add(user);
            }
        }

        // 결과 메일 발송 카운트 계산
        for (int i = 0; i < id_list.length; i++) {
            String user = id_list[i];
            Set<String> reportedByUser = reporterMap.get(user);

            for (String reported : reportedByUser) {
                if (bannedUsers.contains(reported)) {
                    answer[i]++;
                }
            }
        }

        return answer;
    }
}