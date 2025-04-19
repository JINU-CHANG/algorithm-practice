import java.util.*;

class Solution {
    
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        return solve(n, times);
    }
    
    private static long solve(int n, int[] times) {
        long left = 1;
        long right = (long) times[times.length - 1] * n;

        while (left < right) {
            long mid = (left + right) / 2;
            if (calculate(mid, times) < n) { // 심사 불가능 → 시간 더 늘려야
                left = mid + 1;
            } else { // 심사 가능 → 더 적은 시간도 가능한지 줄여봄
                right = mid;
            }
        }
        return left; // or right (같음)
    }
    
    private static long calculate(long mid, int[] times) {
        long sum = 0;
        for (int i = 0; i < times.length; i++) {
            sum += (mid / times[i]);
        }
        return sum;
    }
}
