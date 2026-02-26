import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] directions = {3, 0, 1, 2};
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int y, x, d;
    static int[][] map;
    static int count;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j= 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            // 1.
            if (map[y][x] == 0) {
                map[y][x] = 2;
                count++;
            }

            // 4방향 빈칸 확인
            int notClean = 0;
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny >= n || nx >= m || ny < 0 || nx < 0) continue;
                if (map[ny][nx] == 0) notClean++;
            }

            if (notClean == 0) {
                boolean stop = step1();
                if (stop) {
                    System.out.println(count);
                    return;
                }
            } else {
                step2();
            }
        }
    }

    private static boolean step1() {
        // 한 칸 후진
        int ny;
        int nx;
        if (d == 0) {
            ny = y + 1;
            nx = x;
        } else if (d == 1) {
            ny = y;
            nx = x - 1;
        } else if (d == 2) {
            ny = y - 1;
            nx = x;
        } else {
            ny = y;
            nx = x + 1;
        }

        if (ny >= n || nx >= m || ny < 0 || nx < 0 || map[ny][nx] == 1) {
            return true;
        }

        if (map[ny][nx] == 2) {
            y = ny;
            x = nx;
        }

        return false;
    }

    private static void step2() {
        // 90도 회전
        d = directions[d];

        // 앞쪽 칸 확인 & 전진
        int ny;
        int nx;
        if (d == 0) {
            ny = y - 1;
            nx = x;
        } else if (d == 1) {
            ny = y;
            nx = x + 1;
        } else if (d == 2) {
            ny = y + 1;
            nx = x;
        } else {
            ny = y;
            nx = x - 1;
        }

        if (ny >= n || nx >= m || ny < 0 || nx < 0) return;

        if (map[ny][nx] == 0) {
            map[y][x] = 2;
            y = ny;
            x = nx;
        }
    }
}
