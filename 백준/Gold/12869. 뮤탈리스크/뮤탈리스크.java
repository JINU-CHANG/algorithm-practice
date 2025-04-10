import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] array = {{9, 3, 1}, {9, 1, 3}, {3, 9, 1}, {3, 1, 9}, {1, 3, 9}, {1, 9, 3}};
    static int[][][] dp;
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] current = new int[3];
        for (int i = 0; i < n; i++) {
            current[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[current[0] + 1][current[1] + 1][current[2] + 1];
        bfs(current);
        System.out.println(dp[0][0][0]);
    }

    private static void bfs(int[] current) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(current);
        while (!queue.isEmpty()) {
            int[] polled = queue.poll();
            for (int i = 0; i < 6; i++) {

                int na = Math.max(polled[0] - array[i][0], 0);
                int nb = Math.max(polled[1] - array[i][1], 0);
                int nc = Math.max(polled[2] - array[i][2], 0);

                if (dp[na][nb][nc] == 0) { // 아직 방문 X
                    dp[na][nb][nc] = dp[polled[0]][polled[1]][polled[2]] + 1;
                    queue.add(new int[] {na, nb, nc});
                }

                if (na == 0 && nb == 0 && nc == 0) return;
            }
        }
    }
}
