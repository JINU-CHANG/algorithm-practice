import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[][] matrixA;
    static int[][] matrixB;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        matrixA = new int[n][m];
        matrixB = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                matrixA[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                matrixB[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }

        solve();
        System.out.println(ans);
    }

    private static void solve() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((i > n - 3 || j > m - 3)) {
                    if (matrixA[i][j] != matrixB[i][j]) {
                        ans = -1;
                        return;
                    }

                    continue;
                }

                if (matrixA[i][j] != matrixB[i][j]) {
                    switchMatrix(i, j);
                    ans++;
                }
            }
        }
    }

    private static void switchMatrix(int y, int x) {
        for (int i = y; i < y + 3; i++) {
            for (int j = x; j < x + 3; j++) {
                if (matrixA[i][j] == 0) matrixA[i][j] = 1;
                else matrixA[i][j] = 0;
            }
        }
    }
}
