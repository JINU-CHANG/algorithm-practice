import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static boolean[][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int[][] dp;
    static int h, w;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        map = new int[h][w];
        visited = new boolean[h][w];
        dp = new int[h][w];

        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        dfs(0, 0, map[0][0]);
        System.out.println(dp[0][0]);
    }

    private static int dfs(int y, int x, int height) {
        if (y == h - 1 && x == w - 1) {
            return 1;
        }

        dp[y][x] = 0;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny >= h || nx >= w || ny < 0 || nx < 0) continue;
            if (dp[ny][nx] == 0) continue;
            if (height <= map[ny][nx]) continue;
            if (dp[ny][nx] > 0) {
                dp[y][x] += dp[ny][nx];
                continue;
            }

            dp[y][x] += dfs(ny, nx, map[ny][nx]);
        }

        return dp[y][x];
    } // https://www.acmicpc.net/board/view/139826
}
