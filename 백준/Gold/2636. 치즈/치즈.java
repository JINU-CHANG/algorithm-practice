import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static boolean[][] visited;
    static int[][] map;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int time = 0;
    static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            int temp = 0;
            visited = new boolean[n][m];
            dfs(0, 0);

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == 0) continue;
                    for (int k = 0; k < 4; k++) {
                        int ny = i + dy[k];
                        int nx = j + dx[k];
                        if (ny >= n || nx >= m || ny < 0 || nx < 0) continue;
                        if (visited[ny][nx]) map[i][j] = 0; // 치즈 녹음
                    }
                    temp++;
                }
            }

            if (temp == 0) {
                System.out.println(time);
                System.out.println(count);
                break;
            }
            count = temp;
            time++;
        }


    }

    private static void dfs(int y, int x) {
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny >= n || nx >= m || ny < 0 || nx < 0) continue;
            if (visited[ny][nx] || map[ny][nx] == 1) continue;

            visited[ny][nx] = true;
            dfs(ny, nx);
        }
    }
}
