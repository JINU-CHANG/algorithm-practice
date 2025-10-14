import java.util.*;

class Solution {
    
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] floyd = new int[n + 1][n + 1];
        
        for (int i = 0; i < results.length; i++) {
            int win = results[i][0];
            int lose = results[i][1];
            
            floyd[win][lose] = 1;
            floyd[lose][win] = -1;
        }
        
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                for (int k = 1; k < n + 1; k++) {
                    if (floyd[i][k] == 1 && floyd[k][j] == 1) {
                        floyd[i][j] = 1;
                        floyd[j][i] = -1;
                    }
                    
                    if (floyd[i][k] == -1 && floyd[k][j] == -1) {
                        floyd[i][j] = -1;
                        floyd[j][i] = 1;
                    }
                }
            }
        }
         
        for (int i = 1; i < n + 1; i++) {
            int count = 0;
            for (int j = 1; j < n + 1; j++) {
                if (floyd[i][j] == 1 || floyd[i][j] == -1) count++;
            }
            
            if (count == n - 1) {
                answer++;
            }
        }
        
        return answer;
    }
}