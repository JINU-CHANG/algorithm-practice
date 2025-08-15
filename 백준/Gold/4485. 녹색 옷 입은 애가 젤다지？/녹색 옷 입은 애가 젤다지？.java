import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] map;
    static int[][] dp;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int turn = 0;
        while (true) {
            turn++;
            n = Integer.parseInt(br.readLine());

            if (n == 0) break;

            map = new int[n][n];
            dp = new int[n][n];

            for (int i = 0; i < n; i++) {
                Arrays.fill(dp[i], Integer.MAX_VALUE);
            }

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
            queue.add(new int[]{0, 0, map[0][0]});
            dp[0][0] = map[0][0];

            while (!queue.isEmpty()) {
                int[] polled = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int ny = polled[0] + dy[i];
                    int nx = polled[1] + dx[i];

                    if (ny >= n || nx >= n || ny < 0 || nx < 0) continue;
                    if (dp[ny][nx] <= polled[2] + map[ny][nx]) continue;

                    dp[ny][nx] = polled[2] + map[ny][nx];
                    queue.offer(new int[]{ny, nx, dp[ny][nx]});
                }
            }

            sb.append("Problem ").append(turn).append(": ").append(dp[n - 1][n - 1]).append("\n");
        }

        System.out.println(sb);
    }
}
