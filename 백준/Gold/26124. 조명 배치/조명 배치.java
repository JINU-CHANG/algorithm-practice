import java.io.*;
import java.util.*;

public class Main {

    static int h, w;
    static int[][] asIs;
    static int[][] toBe; // 설계도
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static boolean possible = true;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        asIs = new int[h][w];
        toBe = new int[h][w];

        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                toBe[i][j] = Integer.parseInt(st.nextToken()); // 설계도
                if (toBe[i][j] == -1) asIs[i][j] = -1; // 벽 표시
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (canChange(i, j)) {
                    asIs[i][j] = toBe[i][j];
                    change(i, j);
                    ans++;
                }

                if (!possible) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (asIs[i][j] != toBe[i][j]) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(ans);
    }

    private static boolean canChange(int y, int x) {
        if (toBe[y][x] == 0 || toBe[y][x] == -1) return false;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny >= h || nx >= w || ny < 0 || nx < 0) continue;
            if (toBe[ny][nx] == -1) continue;
//            if (toBe[ny][nx] == toBe[y][x]) asIs[ny][nx] = toBe[y][x];
            if (toBe[y][x] - toBe[ny][nx] > 1) {
                possible = false;
                return false;
            }
            if (toBe[ny][nx] > toBe[y][x]) return false;
        }

        return true;
    }

    private static void change(int y, int x) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(y);
        queue.add(x);

        while (!queue.isEmpty()) {
            y = queue.poll();
            x = queue.poll();

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                int nl = asIs[y][x] - 1; // 새로운 밝기

                if (ny >= h || nx >= w || ny < 0 || nx < 0) continue;
                if (toBe[ny][nx] == -1) continue; // 벽이 있는 곳
                if (toBe[ny][nx] > nl) continue; // 방문할 필요 없는 곳
                if (asIs[y][x] == 1) continue; // 영향력이 끝나는 곳
                if (Math.abs(asIs[y][x] - asIs[ny][nx]) == 1) continue; // 방문했던 곳
                asIs[ny][nx] = nl;

                queue.add(ny);
                queue.add(nx);
            }
        }
    }
}
