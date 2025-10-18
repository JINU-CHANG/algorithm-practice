import java.util.*;

class Solution {
    
    static List<List<Integer>> list = new ArrayList<>();
    static boolean[] visited;
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        
        visited = new boolean[n + 1];
        for (int[] arr : wires) {
            list.get(arr[0]).add(arr[1]);
            list.get(arr[1]).add(arr[0]);
        }
        
        for (int i = 0; i < wires.length; i++) {
             visited[wires[i][0]] = true;
             int num = dfs(wires[i][0], wires[i][1]);
             visited[wires[i][0]] = false;
             answer = Math.min(answer, Math.abs(num - (n - num)));
        }
        
        return answer;
    }
    
    private static int dfs(int start, int end) {
        int cnt = 1;
        
        for (int i : list.get(start)) {
            if (i == end) continue;
            if (visited[i]) continue;
            
            visited[i] = true;
            cnt += dfs(i, end);
            visited[i] = false;
        }
        
        return cnt;
    }
}