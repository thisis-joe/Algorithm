class Solution {
    public int[] solution(String s) {
        String x = s;
        int zeroCnt = 0;
        int operCnt = 0;
        while(x.length()!=1){
            for(char c : x.toCharArray()){
                if(c=='0') zeroCnt++;
            }
            x = Integer.toBinaryString(x.replaceAll("0","").length());
            operCnt++;
        }
        return new int[]{operCnt,zeroCnt};
        
    }
}
