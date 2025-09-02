import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        String todayDate[] = today.split("\\.");
        int todayY = Integer.parseInt(todayDate[0]);
        int todayM = Integer.parseInt(todayDate[1]);
        int todayD = Integer.parseInt(todayDate[2]);
        int todayDayValue = todayY * 12 * 28 + todayM * 28 + todayD;
        
        Map<String,Integer> termMap = new HashMap<>();
        for(String t : terms){
            String[] term = t.split(" ");
            termMap.put(term[0],Integer.parseInt(term[1])*28);
        }
        
        List<Integer> deleteList = new ArrayList<>();
        int privacyNum = 1;
        for(String p : privacies){
            String[] privacy = p.split("\\.");
            String[] privacyDT = privacy[2].split(" ");
            
            int privacyY = Integer.parseInt(privacy[0]);
            int privacyM = Integer.parseInt(privacy[1]);
            int privacyD = Integer.parseInt(privacyDT[0]);
            int privacyDayValue = privacyY * 12 * 28 + privacyM * 28 + privacyD;
            String privacyT = privacyDT[1];
            
            
            if(todayDayValue >= privacyDayValue + termMap.get(privacyT)){ //파기조건
                deleteList.add(privacyNum);
                privacyNum++;
                continue;
            }
            else{
                privacyNum++;
                continue;
            }
        }
        
        return deleteList.stream().mapToInt(i->i).toArray();
    }
}