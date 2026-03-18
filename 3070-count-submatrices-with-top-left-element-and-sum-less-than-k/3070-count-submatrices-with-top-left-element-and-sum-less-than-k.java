import java.util.*;

class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int w = grid[0].length;
        int h = grid.length;
        int ans = 0;

        int[][] prefixSum = new int[h][w];
        prefixSum[0][0] = grid[0][0];
        for (int i = 1; i < w; i++) {
            prefixSum[0][i] = prefixSum[0][i - 1] + grid[0][i];
        }

        for (int i = 1; i < h; i++) {
            prefixSum[i][0] = prefixSum[i - 1][0] + grid[i][0];
            for (int j = 1; j < w; j++) {
                prefixSum[i][j] = prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1] + grid[i][j]; 
            }
        }

        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= w; j++) {
                // 누적합 이용
                if (prefixSum[i - 1][j - 1] <= k) ans++; 
                //System.out.println(prefixSum[i - 1][j - 1]);
            }
        }

        return ans;
    }
}