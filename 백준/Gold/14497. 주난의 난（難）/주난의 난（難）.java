import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static char[][] map;
    static boolean[][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int x1, y1;
    static int x2, y2;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        x1 = Integer.parseInt(st.nextToken()) - 1;
        y1 = Integer.parseInt(st.nextToken()) - 1;
        x2 = Integer.parseInt(st.nextToken()) - 1;
        y2 = Integer.parseInt(st.nextToken()) - 1;

        map = new char[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        while (true) {
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{x1, y1});
            visited = new boolean[n][m];
            visited[x1][y1] = true;
            count ++;
            while (!queue.isEmpty()) {
                int[] polled = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int ny = polled[0] + dy[i];
                    int nx = polled[1] + dx[i];

                    if (ny >= n || nx >= m || ny < 0 || nx < 0)
                        continue;
                    if (visited[ny][nx]) continue;

                    visited[ny][nx] = true;
                    if (map[ny][nx] == '0') {
                        queue.add(new int[]{ny, nx});
                    } else if (map[ny][nx] == '1') {
                        map[ny][nx] = '0';
                    } else if (map[ny][nx] == '#') {
                        System.out.println(count);
                        return;
                    }
                }
            }
        }
    }
}
