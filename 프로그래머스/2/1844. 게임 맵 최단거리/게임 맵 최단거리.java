import java.util.*;

class Node {
    int y;
    int x;
    int count;
    
    Node(int y, int x, int count) {
        this.y = y;
        this.x = x;
        this.count = count;
    }
}

class Solution {
    
    public int solution(int[][] maps) {
        int m = maps.length;
        int n = maps[0].length;
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};
        boolean[][] visited = new boolean[m][n];
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 1));
        
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int ny = node.y + dy[i];
                int nx = node.x + dx[i];
                int ncount = node.count + 1;
                
                if (ny >= m || nx >= n || ny < 0 || nx < 0) continue;
                if (visited[ny][nx] || maps[ny][nx] == 0) continue;
                if (ny == m - 1 && nx == n - 1) return ncount;
                
                visited[ny][nx] = true;
                queue.add(new Node(ny, nx, ncount));
            }
        }
        
        return -1;
    }
}