import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[][] map;
    static int[][] dp;
    static int wx = -1;
    static int wy = -1;
    static int[] wallX = new int[2];
    static int[] wallY = new int[2];
    static int[] dy = {-1, 0};
    static int[] dx = {0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = Integer.MIN_VALUE;
            }
        }

        st = new StringTokenizer(br.readLine());
        int y1 = Integer.parseInt(st.nextToken());
        int x1 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        if (y1 == y2 && x1 != x2) {
            wallX[0] = Math.min(x1, x2);
            wallX[1] = Math.max(x1, x2);
            wy = y1;
        } else if (y1 != y2 && x1 == x2) {
            wallY[0] = Math.min(y1, y2);
            wallY[1] = Math.max(y1, y2);
            wx = x1;
        }

        dp[0][0] = map[0][0];
        dp();

        if (dp[n - 1][m - 1] == Integer.MIN_VALUE) {
            System.out.println("Entity");
        } else {
            System.out.println(dp[n - 1][m - 1]);
        }
    }

    private static void dp() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 2; k++) {
                    int by = i + dy[k];
                    int bx = j + dx[k];

                    if (by >= n || bx >= m || by < 0 || bx < 0) continue;
                    if (dp[by][bx] == Integer.MIN_VALUE) continue;
                    if (wallExist(k, i, j)) continue;
                    dp[i][j] = Math.max(dp[by][bx] + map[i][j], dp[i][j]);
                }
            }
        }
    }

    private static boolean wallExist(int direction, int y, int x) {
        if (direction == 0 && wx == -1 && y == wy) { // 위쪽
            return x >= wallX[0] && x < wallX[1];
        } else if (direction == 1 && wy == -1 && x == wx) { // 왼쪽
            return y >= wallY[0] && y < wallY[1];
        }

        return false;
    }
}
