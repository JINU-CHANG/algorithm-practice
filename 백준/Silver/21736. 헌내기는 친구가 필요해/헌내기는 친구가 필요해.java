import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Info {
    int y;
    int x;

    public Info(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Main {

    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static Info start;
    static int answer;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'I') start = new Info(i, j);
            }
        }

        bfs(start);
        if (answer == 0) {
            System.out.println("TT");
        } else {
            System.out.println(answer);
        }
    }

    private static void bfs(Info info) {
        Queue<Info> queue = new ArrayDeque<>();

        queue.add(info);
        visited[info.y][info.x] = true;

        while (!queue.isEmpty()) {
            Info polled = queue.poll();

            for (int i = 0; i < 4; i++) {
                int ny = polled.y + dy[i];
                int nx = polled.x + dx[i];

                if (ny >= n || nx >= m || ny < 0 || nx < 0) continue;
                if (map[ny][nx] == 'X' || visited[ny][nx]) continue;
                if (map[ny][nx] == 'P') {
                    answer++;
                }

                visited[ny][nx] = true;
                queue.add(new Info(ny, nx));
            }
        }
    }
}
