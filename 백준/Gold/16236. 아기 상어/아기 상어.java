import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][] visited;
    static int size = 2;
    static int count = 0;
    static int y, x;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    y = i;
                    x = j;
                    map[i][j] = 0;
                }
            }
        }

        while (true) {
            visited = new boolean[n][n];
            int[] result = bfs(y, x);
            if (result == null) {
                System.out.println(ans);
                break;
            }

            //System.out.println(Arrays.toString(result));
            y = result[0];
            x = result[1];
            map[y][x] = 0;
            count++;
            if (size == count) {
                size++;
                count = 0;
            }
            ans += result[2];
        }
    }

    private static int[] bfs(int y, int x) {
        int result = -1;
        List<int[]> results = new ArrayList<>();
        Queue<int[]> queue = new LinkedList<>();
        visited[y][x] = true;
        queue.add(new int[]{y, x, 0});

        while (!queue.isEmpty()) {
            int[] polled = queue.poll();

            if (result != -1 && polled[2] > result) {
                break;
            }

            for (int i = 0; i < 4; i++) {
                int ny = polled[0] + dy[i];
                int nx = polled[1] + dx[i];

                if (ny >= n || nx >= n || ny < 0 || nx < 0) continue;
                if (visited[ny][nx]) continue;
                if (map[ny][nx] > size) continue;

                if (result == -1 && map[ny][nx] > 0 && map[ny][nx] < size) {
                    result = polled[2];
                }
                if (result == polled[2] && map[ny][nx] > 0 && map[ny][nx] < size) {
                    results.add(new int[]{ny, nx, polled[2] + 1});
                }

                visited[ny][nx] = true;
                queue.add(new int[]{ny, nx, polled[2] + 1});
            }
        }

        if (results.isEmpty()) {
            return null;
        }

        Collections.sort(results, (a1, a2) -> {
            if (a1[0] == a2[0]) return a1[1] - a2[1];
            else return (a1[0] - a2[0]);
        });

        return results.get(0);
    }
}
