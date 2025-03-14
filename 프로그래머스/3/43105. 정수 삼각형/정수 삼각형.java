import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = Integer.MIN_VALUE;
        
        int y = triangle.length;
        int x = triangle[y - 1].length;
        
        int[][] dp = new int[y][x];
        dp[0][0] = triangle[0][0];
        
        for (int i = 1; i < y; i++) {
            dp[i][0] = dp[i - 1][0] + triangle[i][0];
            
            for (int j = 1; j < triangle[i].length; j++) {
                dp[i][j] = Math.max(dp[i - 1][j] + triangle[i][j], dp[i - 1][j - 1] + triangle[i][j]);
                answer = Math.max(dp[i][j], answer);
            }
        }
        return answer;
    }
}