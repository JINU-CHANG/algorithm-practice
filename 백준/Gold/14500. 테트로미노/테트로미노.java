import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                dfs(i, j, 1, map[i][j]);  // 방문안했으면 dfs
                visited[i][j] = false;
            }
        }

        System.out.println(max);
    }

    private static void dfs(int y, int x, int count, int ans) {
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny >= n || nx >= m || nx < 0 || ny < 0) continue;
            if (visited[ny][nx]) continue;
            if (count == 3) {
                max = Math.max(max, ans + map[ny][nx]);
                //System.out.println(y + " " + x + "ans > " + (ans + map[ny][nx]));
                continue;
            }

            if (count == 2) {
                visited[ny][nx] = true;
                dfs(y, x, count + 1, ans + map[ny][nx]);
                visited[ny][nx] = false;
            }
            visited[ny][nx] = true;
            dfs(ny, nx, count + 1, ans + map[ny][nx]);
            visited[ny][nx] = false;
        }
    }
}
