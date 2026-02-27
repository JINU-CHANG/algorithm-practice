import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        // 출발순 정렬
        Arrays.sort(routes, (i1, i2) -> {
            return i1[1] - i2[1];
        });
        
        // 기준
        int last = routes[0][1];
        answer++;
        for (int i = 1; i < routes.length; i++) { 
            if (routes[i][0] <= last) continue;
            
            last = routes[i][1];
            answer++;
        }
        
        return answer;
    }
}