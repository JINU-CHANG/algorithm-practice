import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] map;
    static boolean[] visited;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i + 1][j + 1] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= n; i++) {
            dfs(i, 0);
        }

        System.out.println(ans);
    }

    private static void dfs(int x, int cnt) {
        if (cnt == n / 2) {
            ans = Math.min(ans, Math.abs(calculateDiff()));
            return;
        }

        for (int i = x; i <= n; i++) {
            visited[x] = true;
            dfs(i + 1, cnt + 1);
            visited[x] = false;
        }
    }

    private static int calculateDiff() {
        int startSum = 0;
        int linkSum = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) continue;
                if (visited[i] && visited[j]) startSum += map[i][j];
                else if (!visited[i] && !visited[j]) linkSum += map[i][j];
            }
        }
        return Math.abs(startSum - linkSum);
    }
}
