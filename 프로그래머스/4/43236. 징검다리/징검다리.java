import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        return solve(n, distance, rocks);
    }
    
    private static int solve(int n, int distance, int[] rocks) {
        int left = 2;
        int right = distance + 1;
        
        while (left < right) {
            int mid = (left + right) / 2;
            
            if (getRemovedRockCnt(rocks, mid, distance) > n) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return right - 1;
    }
    
    private static int getRemovedRockCnt(int[] rocks, int mid, int distance) {
        int before = 0; 
        int end = distance;
        
        int removeCnt = 0;
        for(int i = 0; i < rocks.length; i++){
            if(rocks[i] - before < mid) {
                removeCnt++;
                continue;
            }
            before = rocks[i];
        }
        if(end - before < mid) removeCnt++;

        return removeCnt;
    }
}