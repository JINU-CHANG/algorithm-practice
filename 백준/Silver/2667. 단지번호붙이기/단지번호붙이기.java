import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    static int n;
    static boolean[][] visited;
    static int[][] map;
    static int[] dx = {0 , 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static List<Integer> ans = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();

            for (int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                if (map[y][x] == 1 && !visited[y][x]) {
                    ans.add(dfs(y, x));
                }
            }
        }

        Collections.sort(ans);
        sb.append(ans.size()).append("\n");
        ans.forEach(x -> sb.append(x).append("\n"));

        System.out.println(sb);
    }

    public static int dfs(int y, int x) {
        visited[y][x] = true;
        int cnt = 1;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || nx < 0 || nx >= n || ny >= n) continue;
            if (visited[ny][nx]) continue;
            if (map[ny][nx] == 0) continue;

            cnt += dfs(ny, nx);
        }

        return cnt;
    }
}

