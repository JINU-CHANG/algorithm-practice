import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int h, w;
    static boolean[][] map;
    static boolean[][] checked;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        map = new boolean[h][w];
        checked = new boolean[h][w];

        for (int i = 0; i < h; i++) {
            String s = br.readLine();
            for (int j = 0; j < w; j++) {
                char c = s.charAt(j);
                if (c == 'L') map[i][j] = true;
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (map[i][j]) {
                    bfs(i, j);
                }
            }
        }

        System.out.println(max);
    }

    private static void bfs(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{y, x, 0});
        checked = new boolean[h][w];
        checked[y][x] = true;

        while (!queue.isEmpty()) {
            int[] polled = queue.poll();
            for (int i = 0; i < 4; i++) {
                int ny = polled[0] + dy[i];
                int nx = polled[1] + dx[i];

                if (ny >= h || nx >= w || ny < 0 || nx < 0) continue;
                if (checked[ny][nx]) continue;
                if (!map[ny][nx]) continue;

                max = Math.max(max, polled[2] + 1);
                checked[ny][nx] = true;
                queue.offer(new int[]{ny, nx, polled[2] + 1});
            }
        }
    }
}
