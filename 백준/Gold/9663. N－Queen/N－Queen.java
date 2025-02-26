import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static boolean[][] queenPosition;
    static int[] dy = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dx = {0, 0, -1, 1, -1, 1, -1, 1};
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        queenPosition = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            queenPosition[0][i] = true;
            dfs(0, i);
            queenPosition[0][i] = false;
        }

        System.out.println(ans);
    }

    private static void dfs(int y, int x) {
        if (y == n - 1) {
            ans++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!canGo(y + 1, i)) continue;
            queenPosition[y + 1][i] = true;
            dfs(y + 1, i);
            queenPosition[y + 1][i] = false;
        }
    }

    private static boolean canGo(int y, int x) {
        for (int i = 0; i < 8; i++) {
            int count = 1;
            while (true) {
                int ny = y + (count * dy[i]);
                int nx = x + (count * dx[i]);

                if (ny < 0 || nx < 0 || ny >= n || nx >= n) break;
                if (queenPosition[ny][nx]) return false;
                count++;
            }
        }

        return true;
    }
}
