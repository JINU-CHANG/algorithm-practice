import java.util.*;

class Solution {
    
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int ySize, xSize;
    static int[][] visited;
    
    public int solution(int[][] land) {
        int answer = Integer.MIN_VALUE;
        ySize = land.length;
        xSize = land[0].length;
        
        // 미리 저장
        int num = 1;
        visited = new int[ySize][xSize];
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < ySize; i++) {
            for (int j = 0; j < xSize; j++) {
                if (land[i][j] == 0 || visited[i][j] > 0) continue;
                visited[i][j] = num;
                int count = dfs(land, i, j, num);
                map.put(num, count);
                num++;
            }
        }
        
        for (int i = 0; i < xSize; i++) {
            int result = 0;
            Set<Integer> tags = new HashSet<>();
            for (int j = 0; j < ySize; j++) {
                if (land[j][i] == 0 || tags.contains(visited[j][i])) continue;
                result += map.get(visited[j][i]);
                tags.add(visited[j][i]);
            }
            
            answer = Math.max(answer, result);
        }
        
        return answer;
    }
    
    private int dfs(int[][] land, int y, int x, int num) {
        int cnt = 1;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            
            if (ny >= ySize || nx >= xSize || ny < 0 || nx < 0) continue;
            if (visited[ny][nx] > 0 || land[ny][nx] == 0) continue;
            visited[ny][nx] = num;
            cnt += dfs(land, ny, nx, num);
        }
        
        return cnt;
    }
}