
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Info {
    int x;
    int y;
    int day;

    public Info(int x, int y, int day) {
        this.x = x;
        this.y = y;
        this.day = day;
    }
}

public class Main {

    static int m, n, h;
    static int[][] tomatos;
    static boolean[][] visited;
    static List<Integer> dx = new ArrayList<>(List.of(-1, 1, 0, 0));
    static List<Integer> dy = new ArrayList<>(List.of(0, 0, -1, 1));
    static Queue<Info> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        tomatos = new int[n * h][m];
        visited = new boolean[n * h][m];

        dx.add(n);
        dx.add(-n);
        dy.add(0);
        dy.add(0);

        for (int i = 0; i < n * h; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                int tomato = Integer.parseInt(st.nextToken());
                tomatos[i][j] = tomato;

                if (tomato == 1) {
                    queue.add(new Info(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }

        System.out.println(calculateDays());
    }

    public static int bfs() {
        int days = 0;
        while (!queue.isEmpty()) {
            Info polled = queue.poll();
            days = polled.day;

            for (int i = 0; i < 6; i++) {
                int nx = polled.x + dx.get(i);
                int ny = polled.y + dy.get(i);

                if (nx < 0 || ny < 0 || nx >= (n * h) || ny >= m) continue;
                if (Math.abs(polled.x - nx) != n && (polled.x / n) != (nx / n)) continue;
                if (visited[nx][ny]) continue;
                if (tomatos[nx][ny] == -1) continue;

                queue.add(new Info(nx, ny, polled.day + 1));
                tomatos[nx][ny] = 1;
                visited[nx][ny] = true;
            }
        }

        return days;
    }

    public static int calculateDays() {
        int days = bfs();

        for (int i = 0; i < n * h; i++) {
            for (int j = 0; j < m; j++) {
                if (tomatos[i][j] == 0) {
                    return -1;
                }
            }
        }

        return days;
    }
}
