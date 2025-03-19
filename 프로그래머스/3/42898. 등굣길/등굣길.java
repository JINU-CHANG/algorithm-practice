import java.util.*;

class Info {
    int y;
    int x;
    int cnt;
    
    Info(int y, int x, int cnt) {
        this.y = y;
        this.x = x;
        this.cnt = cnt;
    }
}

class Solution {
    
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        int[][] dp = new int[n][m];
        for (int i = 0; i < puddles.length; i++) {
            int y = puddles[i][1] - 1;
            int x = puddles[i][0] - 1;
            
            dp[y][x] = -1;
        }
        
        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {    
                if (dp[i][j] == -1) continue; // 웅덩이
                if (i - 1 >= 0 && dp[i - 1][j] >= 0) dp[i][j] += dp[i - 1][j] % 1_000_000_007;
                if (j - 1 >= 0 && dp[i][j - 1] >= 0) dp[i][j] += dp[i][j - 1] % 1_000_000_007;
            }
        }
    
        return dp[n - 1][m - 1] % 1_000_000_007;
    }
}