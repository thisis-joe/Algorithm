import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        //각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 
        // 회의의 최대 개수를 찾아보자.    
        
        int N = sc.nextInt();
        int[][] time = new int[N][2];
        int max = -1;
        
        //입력
        for(int i = 0 ; i < N ; i++){
            time[i][0] = sc.nextInt();
            time[i][1] = sc.nextInt();
        }
        
        
        // NO정렬 -> 시작시간 오름차순, 시작시간 같으면 도착시간 오름차순
        // YES정렬 -> 종료시간 오름차순, 종료시간 같으면 시작시간 오름차순 
        Arrays.sort(time, (a, b) -> {
            if (a[1] == b[1]) return Integer.compare(a[0], b[0]); // 종료시간 같으면 시작시간 오름차순
            return Integer.compare(a[1], b[1]); // 종료시간 오름차순
        });
        
        //개수 세기
        // for(int i = 0 ; i < N ; i++){
        //     int cnt = 1; // 자기자신 1개 부터 시작 
        //     int pickEnd = time[i][1]; //처음 종료 시간 
        //     for(int j = 0 ; j < N ; j++){
        //         if(i==j) continue; //자기자신 건너뜀 
        //         else{
        //             if(time[j][0] > pickEnd ){
        //                 cnt++;
        //                 pickEnd = time[j][1];
        //             }
        //         }
        //     }
        //     if(cnt > max) max = cnt;
        // }
        
        // System.out.println(max);
        int count = 0;
        int endTime = 0;

        for (int i = 0; i < N; i++) {
            if (time[i][0] >= endTime) {
                count++;
                endTime = time[i][1];
            }
        }

        System.out.println(count);
        return;
    }
}

