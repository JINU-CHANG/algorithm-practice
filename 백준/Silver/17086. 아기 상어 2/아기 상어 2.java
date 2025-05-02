import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[] dy = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dx = {0, 0, -1, 1, -1, 1, -1, 1};
    static int[][] map;
    static boolean[][] check;
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        check = new boolean[n][m];

        // 상어 위치 입력받기
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int x = Integer.parseInt(st.nextToken());
                if (x == 0) {
                    map[i][j] = x;
                } else {
                    queue.add(new int[]{i, j});
                    check[i][j] = true;
                    map[i][j] = 0;
                }
            }
        }

        // 상어 위치에서 bfs 돌리기
        while (!queue.isEmpty()) {
            int[] polled = queue.poll();
            bfs(polled);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                //System.out.println("i : " + i + ", j : " + j + " > " + map[i][j]);
                answer = Math.max(answer, map[i][j]);
            }
        }
        System.out.println(answer);
    }

    private static void bfs(int[] point) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(point);
        //System.out.println("start > " + point[0] + " , " + point[1]);
        while (!queue.isEmpty()) {
            int[] polled = queue.poll();

            for (int i = 0; i < 8; i++) {
                int ny = polled[0] + dy[i];
                int nx = polled[1] + dx[i];

                if (ny >= n || nx >= m || ny < 0 || nx < 0) continue;
                if (check[ny][nx]) continue; // 상어 있는 곳
                if (map[ny][nx] >= 1 && (map[ny][nx] <= map[polled[0]][polled[1]] + 1)) continue; // 숫자가 크거나 같으면

                map[ny][nx] = map[polled[0]][polled[1]] + 1;
                queue.add(new int[]{ny, nx});
            }
        }
    }
}
