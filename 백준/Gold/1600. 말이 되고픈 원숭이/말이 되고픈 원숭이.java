import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Info {
    int y;
    int x;
    int cnt;
    int kCount;

    Info(int y, int x, int cnt, int kCount) {
        this.y = y;
        this.x = x;
        this.cnt = cnt;
        this.kCount = kCount;
    }
}

public class Main {

    static int[] hy = {2, 1, 2, 1, -2, -1, -2, -1};
    static int[] hx = {1, 2, -1, -2, 1, 2, -1, -2};
    static int[] my = {1, -1, 0, 0};
    static int[] mx = {0, 0, -1, 1};
    static int w, h;
    static int k;
    static int[][] visited;
    static boolean[][] obstacles;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        visited = new int[h][w];
        obstacles = new boolean[h][w];
        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                int x = Integer.parseInt(st.nextToken());
                visited[i][j] = -1;
                if (x == 1) {
                    obstacles[i][j] = true;
                }
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<Info> queue = new ArrayDeque<>();
        if (h == 1 && w == 1) return 0;
        visited[0][0] = k;
        queue.add(new Info(0, 0, 0, k));

        while (!queue.isEmpty()) {
            Info polled = queue.poll();

            int ny = 0;
            int nx = 0;
            int kCount = 0;

            for (int i = 0; i < 4; i++) {
                ny = polled.y + my[i];
                nx = polled.x + mx[i];
                kCount = polled.kCount;

                if (ny >= h || nx >= w || ny < 0 || nx < 0) continue;
                if (ny == h - 1 && nx == w - 1) return polled.cnt + 1;

                if (visited[ny][nx] >= kCount) continue;
                if (obstacles[ny][nx]) continue;

                visited[ny][nx] = kCount;
                queue.add(new Info(ny, nx, polled.cnt + 1, kCount));
            }

            if (polled.kCount > 0) {
                for (int i = 0; i < 8; i++) {
                    ny = polled.y + hy[i];
                    nx = polled.x + hx[i];
                    kCount = polled.kCount - 1;

                    if (ny >= h || nx >= w || ny < 0 || nx < 0) continue;
                    if (ny == h - 1 && nx == w - 1) return polled.cnt + 1;

                    if (visited[ny][nx] >= kCount) continue;
                    if (obstacles[ny][nx]) continue;

                    visited[ny][nx] = kCount;
                    queue.add(new Info(ny, nx, polled.cnt + 1, kCount));
                }
            }
        }

        return -1;
    }
}
