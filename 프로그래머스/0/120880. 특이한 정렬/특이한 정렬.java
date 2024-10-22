import java.util.*;
class Solution {
    public int[] solution(int[] numlist, int n) {
        double[] distance = new double[numlist.length];
        List<Integer> distList = new ArrayList<>();
        for(int i=0;i<numlist.length;i++){
            if(numlist[i]<=n){
                distance[i]=Math.abs(numlist[i]-n)+0.1;
            }
            else distance[i]=Math.abs(numlist[i]-n);
        }
        Arrays.sort(distance);
        for(double dist : distance){
            if(dist%1!=0) distList.add((n-(int)dist)); 
            else distList.add(n+(int)dist); 
        }
        System.out.println(" distance : ");
        return distList.stream().mapToInt(i->i).toArray();
    }
}