class Solution {
    public int solution(String name) {
        
        //상하이동
        int upDown = 0;
        for(char c : name.toCharArray()){
            upDown += Math.min(c-'A','Z'-c+1); //위로, 아래로 중 작은 값 
        }
        
        //그냥 오른쪽 쭉 가는 경우, 돌아가는 경우(2) 3가지 경우에 대해 비교
        int leftRight = name.length()-1;
        for (int i = 0; i < name.length(); i++) {
            int next = i + 1;
            while (next < name.length() && name.charAt(next) == 'A') { // 다음 문자가 'A'인 경우, 끝까지 연속된 A를 찾음
                next++;
            }
            // i에서 되돌아가서 뒤쪽 처리하는 경우, 반대로 뒤에서 먼저 처리하고 오는 경우 중 작은 값
            leftRight = Math.min(leftRight,
                                 Math.min(i * 2 + name.length() - next, (name.length() - next) * 2 + i));
        }

        return upDown + leftRight;
    }
}