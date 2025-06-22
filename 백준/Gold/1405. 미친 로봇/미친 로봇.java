import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] dy = {0, 0, -1, 1}; // 동서남북
    static int[] dx = {1, -1, 0, 0};
    static double[] pArray = new double[4];
    static double result;
    static boolean[][] visited = new boolean[30][30];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < 4; i++) {
            pArray[i] = (double) Integer.parseInt(st.nextToken()) / 100;
        }

        visited[15][15] = true;
        dfs(15, 15, 0, 1);

        System.out.println(result);
    }

    private static void dfs(int y, int x, int count, double p) {
        if (count == n) {
            result += p;
            return;
        }

        // 상,하,좌,우 탐색
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            double np = p * pArray[i];

            // 확률 = 0 or 방문했던 곳이면 pass
            if (visited[ny][nx] || np == 0) continue;

            visited[ny][nx] = true;
            dfs(ny, nx, count + 1, np);
            visited[ny][nx] = false;
        }
    }
}
