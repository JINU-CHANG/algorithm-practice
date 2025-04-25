import java.util.*;
import java.time.*;

class Time {
    LocalTime time;
    
    Time(String time) {
        String[] times = time.split(":");
        this.time = LocalTime.of(0, Integer.parseInt(times[0]), Integer.parseInt(times[1]));
    }
    
    Time(Time time) {
       this.time = time.time;
    }
}

class Solution {
    public String solution(String video_len, String posS, String op_start, String op_end, String[] commands) {
        // opStart
        Time opStart = new Time(op_start);
        
        // opEnd
        Time opEnd = new Time(op_end);
        
        // video_len
        Time videoLen = new Time(video_len);
        
        // pos
        Time pos = new Time(posS);
        
        pos = op(pos, opStart, opEnd);
        for (String command : commands) {
            if (command.equals("next")) {
                pos = next(pos, videoLen);
            } else if (command.equals("prev")) {
                pos = prev(pos);
            }
            
            pos = op(pos, opStart, opEnd);
        }
        
        String[] answers = pos.time.toString().split(":");
        if (answers.length == 2) {
            return answers[1] + ":" + answers[0];
        }
        return answers[1] + ":" + answers[2];
    }
    
    private Time prev(Time pos) {
        if (pos.time.getMinute() == 0 && pos.time.getSecond() < 10) {
            pos.time = LocalTime.of(0, 0, 0);
           }
        else {
           pos.time = pos.time.minusSeconds(10);
        }

        return pos;
    }
    
    private Time next(Time pos, Time videoLen) {
         pos.time = pos.time.plusSeconds(10);
         if (pos.time.isAfter(videoLen.time)) {
            pos.time = videoLen.time;
         }
        
        return pos;
    }
    
    private Time op(Time pos, Time opStart, Time opEnd) {
        if (opStart.time.compareTo(pos.time) <= 0 
            && opEnd.time.compareTo(pos.time) >= 0) {
            return new Time(opEnd);
        }

        return pos;
    }
}