import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static char[][] A;
    static char[][] B;
    static boolean[][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());

       n = Integer.parseInt(st.nextToken());
       m = Integer.parseInt(st.nextToken());

       A = new char[n][m];
       B = new char[n][m];
       visited = new boolean[n][m];
       for (int i = 0; i < n; i++) {
           String line = br.readLine();
           for (int j = 0; j < m; j++) {
               A[i][j] = line.charAt(j);
           }
       }

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                B[i][j] = line.charAt(j);
            }
        }

        solve();
        print();
    }

    public static void solve() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j]) continue;
                dfs(i, j, A[i][j], B[i][j]);
            }
        }
    }

    public static void dfs(int y, int x, char a, char c) {
        visited[y][x] = true;
        A[y][x] = c;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || nx < 0 || ny >= n|| nx >= m) continue;
            if (visited[ny][nx]) continue;
            if (A[ny][nx] != a) continue;

            dfs(ny, nx, a, c);
        }
    }

    public static void print() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i][j] != B[i][j]) {
                    System.out.println("NO");
                    return;
                }
            }
        }

        System.out.println("YES");
    }
}
