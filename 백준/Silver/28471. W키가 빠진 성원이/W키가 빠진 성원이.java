import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static char[][] map;
    static boolean[][] visited;
    static int startY, startX;
    static int[] dy = {-1, 0, 0, -1, -1, 1, 1};
    static int[] dx = {0, -1, 1, -1, 1, -1, 1};
    static int ans = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        map = new char[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                char c = line.charAt(j);
                map[i][j] = c;
                if (c == 'F') {
                    startY = i;
                    startX = j;
                }
            }
        }

        visited[startY][startX] = true;
        dfs(startY, startX);
        System.out.println(ans);
    }
    
    private static void dfs(int y, int x) {
        for (int i = 0; i < 7; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny >= n || nx >= n || ny < 0 || nx < 0) continue;
            if (map[ny][nx] == '#') continue;
            if (visited[ny][nx]) continue;

            visited[ny][nx] = true;
            ans++;
            dfs(ny, nx);
        }
    }
}
