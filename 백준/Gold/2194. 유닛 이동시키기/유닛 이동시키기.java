import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.StringTokenizer;

class Position {
    int y;
    int x;
    int count;

    Position(int y, int x, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Position position = (Position) object;
        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

public class Main {

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static int n, m, A, B, k;
    static Position start;
    static Position end;
    static boolean[][] visited;
    static boolean[][] obstacles;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1][m + 1];
        obstacles = new boolean[n + 1][m + 1];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            obstacles[y][x] = true;
        }

        st = new StringTokenizer(br.readLine());
        start = new Position(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);

        st = new StringTokenizer(br.readLine());
        end = new Position( Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);

        Queue<Position> queue = new LinkedList<>();
        queue.add(start);
        visited[start.y][start.x] = true;

        while (!queue.isEmpty()) {
            Position poll = queue.poll();

            for (int i = 0; i < 4; i++) {
                int ny = poll.y + dy[i];
                int nx = poll.x + dx[i];

                if (ny <= 0 || nx <= 0 || ny > n || nx > m) continue;

                Position np = new Position(ny, nx, poll.count + 1);

                if (visited[np.y][np.x]) continue;

                boolean result = true;
                for (int a = 0; a < A; a++) {
                    for (int b = 0; b < B; b++) {
                        if (ny + a <= 0 || nx + b <= 0 || ny + a > n || nx + b > m) {
                            result = false;
                            continue;
                        }
                        if (obstacles[ny + a][nx + b]) result = false;
                    }
                }

                if (!result) continue;

                if (np.equals(end)) {
                    System.out.println(np.count);
                    return;
                }

                visited[np.y][np.x] = true;
                queue.add(np);
            }
        }

        System.out.println(-1);
    }
}
