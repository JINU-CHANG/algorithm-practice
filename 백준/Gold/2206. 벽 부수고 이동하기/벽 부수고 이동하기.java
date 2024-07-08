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
    int cnt;

    public Info(int x, int y, int d, int cnt) {
        this.x = x;
        this.y = y;
        this.d = d;
        this.cnt = cnt;
    }
}
public class Main {

    static int N, M;
    static int[][] arr;
    static boolean[][][] visited;
    static Queue<Info> queue = new ArrayDeque<>();
    static boolean canMove = false;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[2][N][M];
        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < line.length(); j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        queue.add(new Info(0,0, 1, 0));

        while(!queue.isEmpty()) {
            Info polled = queue.poll();

            if (polled.x == N - 1 && polled.y == M - 1) { // 도착
                canMove = true;
                System.out.println(polled.d);
                break;
            }
            if (polled.x < 0 || polled.y < 0 || polled.x > N - 1 || polled.y > M - 1) continue; // 이동 못하는 위치
            if (arr[polled.x][polled.y] == 1) polled.cnt++;
            if (polled.cnt == 2) continue; // 2번 부수면 불가능
            if (visited[polled.cnt][polled.x][polled.y]) continue;

            visited[polled.cnt][polled.x][polled.y] = true; //방문 가능 -> 방문한 것
            for (int i = 0; i < 4; i++) {
                queue.add(new Info(polled.x + dx[i], polled.y + dy[i], polled.d + 1, polled.cnt));
            }
        }

        if (!canMove) {
            System.out.println(-1);
        }
    }
}
