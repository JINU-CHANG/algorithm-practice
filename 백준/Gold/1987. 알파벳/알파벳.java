import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int R, C;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static boolean[] visited = new boolean[26];
    static int[][] map;
    static int ans = 1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = (s.charAt(j) - 0) - 65;
            }
        }

        visited[map[0][0]] = true;
        dfs(0, 0, 1);
        System.out.println(ans);
    }

    private static void dfs(int y, int x, int count) {
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny >= R || nx >= C || ny < 0 || nx < 0) continue;
            if (visited[map[ny][nx]]) continue;

            visited[map[ny][nx]] = true;
            ans = Math.max(ans, count + 1);
            dfs(ny, nx, count + 1);
            visited[map[ny][nx]] = false;
        }
    }
}
