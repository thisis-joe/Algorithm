import java.util.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        //초단위로 변경     
        String[] v = video_len.split(":");
        String[] p = pos.split(":");
        String[] os = op_start.split(":");
        String[] oe = op_end.split(":");
        
        int video_time    = Integer.parseInt(v[0]) * 60 + Integer.parseInt(v[1]);
        int pos_time      = Integer.parseInt(p[0]) * 60 + Integer.parseInt(p[1]);
        int op_start_time = Integer.parseInt(os[0]) * 60 + Integer.parseInt(os[1]);
        int op_end_time   = Integer.parseInt(oe[0]) * 60 + Integer.parseInt(oe[1]);
        
        //명령
        for(String cmd : commands){
            switch(cmd){
                case "prev" :
                    //오프닝 건너뛰기
                    if(pos_time >= op_start_time && pos_time <= op_end_time){
                        pos_time = op_end_time;
                    }
                    if(pos_time - 10 < 0) pos_time = 0;
                    else pos_time -= 10;
                    //오프닝 건너뛰기
                    if(pos_time >= op_start_time && pos_time <= op_end_time){
                        pos_time = op_end_time;
                    }
                    break;
                case "next" : 
                    //오프닝 건너뛰기
                    if(pos_time >= op_start_time && pos_time <= op_end_time){
                        pos_time = op_end_time;
                    }
                    if(pos_time + 10 > video_time) pos_time = video_time;
                    else pos_time += 10;
                    //오프닝 건너뛰기
                    if(pos_time >= op_start_time && pos_time <= op_end_time){
                        pos_time = op_end_time;
                    }
                    break;
            }
        }
        
        StringBuilder sb = new StringBuilder();        
        sb.append(pos_time / 60 < 10 ? "0" + pos_time / 60 : pos_time / 60);
        sb.append(":");
        sb.append(pos_time % 60 < 10 ? "0" + pos_time % 60 : pos_time % 60);
        
        return sb.toString();
    }
}
