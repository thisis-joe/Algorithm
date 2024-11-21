class Solution {
    public int solution(int n, int m, int[] section) {
        boolean[] painted=new boolean[n+1]; //페인트칠한 부분 (0번 idx 사용X) (section처럼 1번 부터 사용)
        int count=0; //칠한 횟수
        
        for(int i=0;i<section.length;i++){
            if(painted[section[i]] ) continue; //이미 페인트 되었으면 다음 section으로 넘어감.
            else{
                count++;
                for(int p=section[i];p<section[i]+m && p<=n ;p++){ // 현위치 ~ 현위치 +m 색칠
                    painted[p]=true;
                }
            }
        }
        return count;
    }
}