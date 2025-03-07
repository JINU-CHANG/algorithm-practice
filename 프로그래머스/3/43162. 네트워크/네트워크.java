class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
    
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(n, visited, i, computers);
                answer++;
            }
        }
    
        return answer;
    }
    
    private void dfs(int n, boolean[] visited, int visitIdx, int[][] computers) {
        visited[visitIdx] = true;
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            if (computers[visitIdx][i] == 0) continue;
            dfs(n, visited, i, computers);
        }
    }
}