class Solution {
    public int solution(String my_string) {
        int sum = 0;
        my_string = my_string.replaceAll("[a-zA-Z]"," ");
        my_string = my_string.replaceAll("\\s+"," ").trim();
        String[] strArr = my_string.split(" ");
        // 공백으로 숫자 부분을 분리
        if (my_string.isEmpty()) {
            return 0;  // 숫자가 없는 경우 0 반환
        }
        for(String str : strArr){
            sum += Integer.parseInt(str);
        }
        return sum;
    }
}