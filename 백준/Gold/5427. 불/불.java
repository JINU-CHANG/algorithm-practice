import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static char[][] map;
    static int w, h;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static Queue<int[]> queue;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(st.nextToken());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            map = new char[h][w];
            queue = new ArrayDeque<>();
            int y = 0;
            int x = 0;
            for (int i = 0; i < h; i++) {
                String s = br.readLine();
                for (int j = 0; j < w; j++) {
                    map[i][j] = s.charAt(j);
                    if (map[i][j] == '*') queue.add(new int[]{'*', i, j});
                    if (map[i][j] == '@') {
                        y = i;
                        x = j;
                    }
                }
            }

            queue.add(new int[]{'@', y, x, 0});

            int ans = bfs();
            if (ans == -1) {
                sb.append("IMPOSSIBLE").append("\n");
            } else {
                sb.append(ans).append("\n");
            }
        }

        System.out.println(sb);
    }

    private static int bfs() {
        while (!queue.isEmpty()) {
            int[] polled = queue.poll();

            if (polled[0] == '*') {
                for (int i = 0; i < 4; i++) {
                    int ny = polled[1] + dy[i];
                    int nx = polled[2] + dx[i];

                    if (ny >= h || nx >= w || ny < 0 || nx < 0)
                        continue;
                    if (map[ny][nx] == '#' || map[ny][nx] == '*')
                        continue;

                    map[ny][nx] = '*';
                    queue.add(new int[]{'*', ny, nx});
                }
            } else {
                for (int i = 0; i < 4; i++) {
                    int ny = polled[1] + dy[i];
                    int nx = polled[2] + dx[i];

                    if (ny >= h || nx >= w || ny < 0 || nx < 0) {
                        return polled[3] + 1;
                    }
                    if (map[ny][nx] == '#' || map[ny][nx] == '*' || map[ny][nx] == '@')
                        continue;
                    
                    map[ny][nx] = '@';
                    queue.add(new int[]{'@', ny, nx, polled[3] + 1});
                }
            }
        }

        return -1;
    }
}
