import java.util.*;

class Solution {

    static boolean[] visited;
    static int answer = -1;
    
    public int solution(int k, int[][] dungeons) {
        Arrays.sort(dungeons, (o1, o2) -> -(o1[0] - o2[0]));
        visited = new boolean[dungeons.length];
        dfs(dungeons, 0, k);
        return answer;
    }
    
    private static void dfs(int[][] dungeons, int cnt, int nk) {
        for (int i = 0; i < dungeons.length; i++) {
            if (visited[i]) continue;
            if (nk < dungeons[i][0]) continue;
            
            visited[i] = true;
            answer = Math.max(answer, cnt + 1);
            dfs(dungeons, cnt + 1, nk - dungeons[i][1]);
            visited[i] = false;
        }
    }
}