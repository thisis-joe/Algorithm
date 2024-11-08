class Solution {
    public int YAKSUcount(int n){
        int cnt=0;
        for(int i=1;i<=n/2;i++){
            if(n%i==0) cnt++;
        }
        return cnt+1; //자기자신 1개 더해야함
    }
    
    public int solution(int left, int right) {
        int sum=0;
        
        for(int i=left;i<=right;i++){
            if(YAKSUcount(i)%2==0) sum+=i;
            else sum-=i;
        }
        
        return sum;
    }
}