import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static Queue<int[]> queue = new LinkedList<>();
    static int a = 1;
    static int count = 0;
    static int n;
    static int[][] sandMap;
    static int ans;

    static int[] vx = {7, 7, 1, 1, 10, 10, 2, 2, 5, 100};
    static int[] leftDy = {-1, 1, -1, 1, -1, 1, -2, 2, 0, 0};
    static int[] leftDx = {0, 0, 1, 1, -1, -1, 0, 0, -2, -1};

    static int[] rightDy = {-1, 1, -1, 1, -1, 1, -2, 2, 0, 0};
    static int[] rightDx = {0, 0, -1, -1, 1, 1, 0, 0, 2, 1};

    static int[] upDy = {0, 0, 1, 1, -1, -1, 0, 0, -2, -1};
    static int[] upDx = {-1, 1, -1, 1, -1, 1, -2, 2, 0, 0};

    static int[] downDy = {0, 0, -1, -1, 1, 1, 0, 0, 2, 1};
    static int[] downDx = {-1, 1, -1, 1, -1, 1, -2, 2, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        sandMap = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                sandMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        queue.add(new int[]{0, -1, 0});
        queue.add(new int[]{1, 0, 1});
        queue.add(new int[]{0, 1, 2});
        queue.add(new int[]{-1, 0, 3});

        int[] position = new int[]{(n - 1) / 2, (n - 1) / 2};
        while (true) {
            int[] result = tMove(position[0], position[1]);
            position = result;
            if (result[0] == 0 && result[1] == 0) break;
        }

        System.out.println(ans);
    }

    private static int[] tMove(int y, int x) {
        int[] polled = queue.poll();
        int ny = y;
        int nx = x;

        for (int i = 1; i <= a; i++) {
            ny = y + i * polled[0];
            nx = x + i * polled[1];
            // 모래이동
            sMove(ny, nx, polled[2]);
            
            if (ny == 0 && nx == 0) break;
        }

        count++;

        if (count == 2) {
            a++;
            count = 0;
        }

        queue.offer(polled);
        return new int[]{ny, nx};
    }

    private static void sMove(int y, int x, int v) {
        if (v == 0) calculate(y, x, leftDy, leftDx);
        else if (v == 1) calculate(y, x, downDy, downDx);
        else if (v == 2) calculate(y, x, rightDy, rightDx);
        else calculate(y, x, upDy, upDx);
    }

    private static void calculate(int y, int x, int[] dy, int[] dx) {
        int sand = sandMap[y][x];
        int sum = 0;

        for (int i = 0; i < 10; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            int plus = (sand * vx[i]) / 100;
            if (ny >= n || nx >= n || ny < 0 || nx < 0) {
                if (i == 9) {
                    ans += plus - sum;
                } else {
                    sum += plus;
                    ans += plus;
                }
            } else {
                if (i == 9) sandMap[ny][nx] += (plus - sum);
                else {
                    sandMap[ny][nx] += plus;
                    sum += plus;
                }
            }
        }

        sandMap[y][x] = 0;
    }
}
