import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Info {
    int x;
    int y;
    int d;

    public Info(int x, int y, int d) {
        this.x = x;
        this.y = y;
        this.d = d;
    }
}
public class Main {

    static int N;
    static int M;
    static int[][] arr;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {-1, 1, 0, 0};
    static boolean[][] visited;
    static Queue<Info> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();

            for (int j = 0; j < M; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        queue.add(new Info(0, 0 ,1));

        while(!queue.isEmpty()) {
            Info polled = queue.poll();

            if (polled.x < 0 || polled.y < 0 || polled.x > N - 1 || polled.y > M - 1) continue;
            if (arr[polled.x][polled.y] == 0) continue;
            if (visited[polled.x][polled.y]) continue;
            if (polled.x == N - 1 && polled.y == M - 1) {
                System.out.println(polled.d);
                break;
            }

            visited[polled.x][polled.y] = true;
            for (int i = 0; i < 4; i++) {
                queue.add(new Info(polled.x + dx[i], polled.y + dy[i], polled.d + 1));
            }
        }
    }
}
