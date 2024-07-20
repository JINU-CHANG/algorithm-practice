import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
    int x;
    int y;
    int time;
    boolean hasSword;

    public Node(int x, int y, int time, boolean hasSword) {
        this.x = x;
        this.y = y;
        this.time = time;
        this.hasSword = hasSword;
    }
}

public class Main {

    static int N, M, T;
    static int[][][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[2][N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[0][i][j] = num;
                map[1][i][j] = num;
            }
        }

        Queue<Node> queue = new ArrayDeque<>();
        Node result = bfs(queue);

        if (result == null || result.time > T) {
            System.out.println("Fail");
        } else{
            System.out.println(result.time);
        }
    }

    public static Node bfs(Queue<Node> queue) {
        queue.add(new Node(0,0,0, false));
        map[0][0][0] = -1;

        while (!queue.isEmpty()) {
            Node polled = queue.poll();

            if (polled.x == N - 1 && polled.y == M - 1) return polled;
            if (polled.time > T) return null;

            for (int i = 0; i < 4; i++) {
                int x = polled.x + dx[i];
                int y = polled.y + dy[i];

                if (x > N - 1 || y > M - 1 || x < 0 || y < 0) continue;

                if (!polled.hasSword) {
                    if (map[0][x][y] == 1) continue;
                    if (map[0][x][y] == -1) continue;
                    if (map[0][x][y] == 2) {
                        queue.add(new Node(x, y, polled.time + 1, true));
                    }
                    map[0][x][y] = -1;
                    queue.add(new Node(x, y, polled.time + 1, polled.hasSword));
                } else {
                    if (map[1][x][y] == -1) continue;
                    map[1][x][y] = -1;
                    queue.add(new Node(x, y, polled.time + 1, polled.hasSword));
                }
            }
        }

        return null;
    }
}
