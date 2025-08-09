import java.util.*;

class Solution {
    public int solution(int[][] info, int n, int m) {
        int[][] dp = new int[info.length][m];
        for (int i = 0; i < info.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        
        if (info[0][1] < m) {
           dp[0][info[0][1]] = 0;
        }
        dp[0][0] = info[0][0];
        
        for (int i = 1; i < info.length; i++) {
            for (int j = 0; j < m; j++) {
                if (dp[i - 1][j] == Integer.MAX_VALUE) continue;
                
                int select = (j + info[i][1]);
                if (select < m) {
                    dp[i][select] = Math.min(dp[i][select], dp[i - 1][j]);
                }
                
                int nselect = j;
                dp[i][nselect] = Math.min(dp[i][nselect], dp[i - 1][j] + info[i][0]);
            }
        }
        
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            if (dp[info.length - 1][i] >= n) continue;
            answer = Math.min(answer, dp[info.length - 1][i]);
        }
        
        if (answer == Integer.MAX_VALUE) answer = -1;
        return answer;
    }
}