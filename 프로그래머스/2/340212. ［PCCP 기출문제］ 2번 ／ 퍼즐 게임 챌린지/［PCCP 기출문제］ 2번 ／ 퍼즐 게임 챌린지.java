import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int max = Integer.MIN_VALUE;
        
        for (int d : diffs) {
            max = Math.max(max, d);
        }
        
        return search(max, diffs, times, limit);
    }
    
    // 이분탐색
    private int search(int max, int[] diffs, int[] times, long limit) {
        int left = 1;
        int right = max;
        
        while (left < right) {
            int mid = (left + right) / 2;
            
            if (calculate(mid, diffs, times) > limit) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return right;
    }
    
    // 총 걸리는 시간 계산
    private long calculate(int level, int[] diffs, int[] times) {
        int timePrev = 0;
        long time = 0;
        for (int i = 0; i < diffs.length; i++) {
            if (diffs[i] <= level) {
                time += times[i];
            } else {
                time += ((times[i] + timePrev) * (diffs[i] - level)) + times[i];
            }
            
            timePrev = times[i];
        }
        
        return time;
    }
}