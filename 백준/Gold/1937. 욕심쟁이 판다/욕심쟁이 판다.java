import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] map;
    static int[][] dp;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int ans = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
            Arrays.fill(dp[i], -1);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int result = dfs(i, j);
                dp[i][j] = Math.max(dp[i][j], result);
            }
        }

//        for (int i = 0; i < n; i++) {
//            System.out.println(Arrays.toString(dp[i]));
//        }

        System.out.println(ans);
    }

    private static int dfs(int y, int x) {
        int max = 1;
        for (int i = 0; i < 4; i++) {
            int cnt = 1;
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny >= n || nx >= n || ny < 0 || nx < 0)
                continue;
            if (map[ny][nx] <= map[y][x])
                continue;
            if (dp[ny][nx] > 0) {
                cnt += dp[ny][nx];
            } else {
                cnt += dfs(ny, nx);
            }

            max = Math.max(max, cnt);
        }

        dp[y][x] = max;
        ans = Math.max(max, ans);
        return max;
    }
}
