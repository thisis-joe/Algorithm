


import java.io.*;
import java.util.*;

public class Main {
	static int arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        loop:
        for(int tc = 1; tc <=T ; tc++){
            char[] cmds = br.readLine().toCharArray();
            int N = Integer.parseInt(br.readLine());
            arr = new int[N];
            StringTokenizer stk = new StringTokenizer(br.readLine().replaceAll("[^0-9]", " ").trim());
            for(int i = 0 ; i < N ; i++) {
            	arr[i] = Integer.parseInt(stk.nextToken());
            }
            int start = 0, end = N-1;
            
            boolean left = true;
            for(char c : cmds){
                switch(c){
                    case 'R':
                        left = !left;
                        break;
                    case 'D':
                    	if(start>end) {  //빈 상태에서 Delete 시도시 에러
                    		sb.append("error\n");
                    		continue loop;
                    	}
                    	if(left) {
                    		++start;
                    	}else {
                    		--end;
                    	}
                        break;
                }
            }
            
           if(start > end) { // 정상적으로 비어있는 경우          
                sb.append("[]\n");
            } else {
            	sb.append("[");
            	if(left) {
            		for(int i = start ; i < end ; i++) {
            			sb.append(arr[i]+",");
            		}
            		sb.append(arr[end]);
            	}else {
            		for(int i = end ; i >start  ; i--) {
            			sb.append(arr[i]+",");
            		}
            		sb.append(arr[start]);
            	}
            	sb.append("]\n");
            }
            
            
        }
        bw.write(sb.toString()); bw.flush(); bw.close(); br.close();
    }
}
