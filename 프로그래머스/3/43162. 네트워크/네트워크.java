class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
    
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (computers[i][j] == 1 && !visited[i]) {
                    dfs(n, visited, j, computers);
                    answer++;
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) answer++;
        }
        
        return answer;
    }
    
    private void dfs(int n, boolean[] visited, int visitIdx, int[][] computers) {
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            if (computers[visitIdx][i] == 0) continue;
            visited[i] = true;
            dfs(n, visited, i, computers);
        }
    }
}