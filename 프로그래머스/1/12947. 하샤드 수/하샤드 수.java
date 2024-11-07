class Solution {
    public boolean solution(int x) {
        int originX=x;
        int hashardSum = 0;
        while(x>0){
            hashardSum+=(x%10);
            x/=10;
        }
        if(originX%hashardSum==0) return true;
        else return false;
    }
}