import java.util.*;

class Solution {
    
    int answer = 0;
    boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            answer++;
            dfs(i, computers);  
        }
        
        return answer;
    }
    
    public void dfs(int start, int[][] computers) {
        int[] arr = computers[start];
        for (int i = 0; i < arr.length; i++) {
            if (start == i) continue;
            if (visited[i] || computers[start][i] == 0) continue;
            
            visited[i] = true;
            dfs(i, computers);
        }
    }
}