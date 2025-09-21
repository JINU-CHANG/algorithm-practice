import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, Q;
    static int length;
    static int[][] map;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        length = (int) Math.pow(2, N);

        map = new int[length][length];
        visited = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < length; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i++) {
            int L = Integer.parseInt(st.nextToken());
            int sLength = (int) Math.pow(2, L);

            for (int j = 0; j <= length - sLength; j += sLength) {
                for (int k = 0; k <= length - sLength; k += sLength) {
                    turn(j, k, sLength);
                }
            }
            minusIce();
        }

        int sum = 0;
        int max = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                sum += map[i][j];
                if (visited[i][j]) continue;
                max = Math.max(max, dfs(i, j));
            }
        }

        System.out.println(sum);
        System.out.println(max - 1);
    }

    // 90도 회전
    private static void turn(int y, int x, int sLength) {
        int[][] temp = new int[length][length];

        int plusy = y;
        for (int i = 0; i < sLength; i++) {
            int plusx = x;
            for (int j = 0; j < sLength; j++) {
                temp[plusy][plusx] = map[y + sLength - 1 - j][x + i];
                plusx++;
            }
            plusy++;
        }

        for (int i = y; i < y + sLength; i++) {
            for (int j = x; j < x + sLength; j++) {
                map[i][j] = temp[i][j];
            }
        }
    }

    // 얼음1씩 줄이기
    private static void minusIce() {
        int z = (int) Math.pow(2, N);
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < z; i++) {
            for (int j = 0; j < z; j++) {
                if (map[i][j] == 0) continue;
                int count = 0;
                for (int k = 0; k < 4; k++) {
                    int ny = i + dy[k];
                    int nx = j + dx[k];

                    if (ny >= z || nx >= z || ny < 0 || nx < 0) continue;
                    if (map[ny][nx] > 0) count++;
                }

                if (count < 3) queue.offer(new int[]{i, j});
            }
        }

        while (!queue.isEmpty()) {
            int[] polled = queue.poll();
            map[polled[0]][polled[1]] -= 1;
        }
    }

    // 얼음 덩어리
    private static int dfs(int y, int x) {
        int count = 1;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny >= length || nx >= length || ny < 0 || nx < 0) continue;
            if (visited[ny][nx]) continue;
            if (map[ny][nx] == 0) continue;

            visited[ny][nx] = true;
            count += dfs(ny, nx);
        }

        return count;
    }
}
