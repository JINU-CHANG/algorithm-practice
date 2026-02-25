import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][n];
        long[][] dp = new long[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dy = {0, 1};
        int[] dx = {1, 0};

        long sum = 0;
        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] != 0) {
                    int v = map[i][j];
                    for (int k = 0; k < 2; k++) {
                        int ny = i + (dy[k] * v);
                        int nx = j + (dx[k] * v);

                        if (ny < 0 || nx < 0 || ny >= n || nx >= n) continue;

                        // 변화
                        if (ny == n - 1 && nx == n - 1) {
                            sum += dp[i][j];
                        } else {
                            dp[ny][nx] += dp[i][j];
                        }
                    }
                }
            }

        }
        System.out.println(sum);
    }
}
