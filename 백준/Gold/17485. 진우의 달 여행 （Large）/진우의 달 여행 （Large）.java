import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[][] array;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        array = new int[n][m + 2];
        dp = new int[n][m + 2][3];

        for (int i = 0; i < n; i++) { // 패딩값 설정
            for (int j = 0; j < m + 2; j++) {
                array[i][j] = 1000000;

                for (int k = 0; k < 3; k++) {
                    dp[i][j][k] = 1000000;
                }
            }
        }

        for (int i = 0; i < n; i++) { //실제 입력값
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < m + 1; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < m + 1; i++) { //초기 셋팅
           dp[1][i][0] = array[0][i - 1] + array[1][i];
           dp[1][i][1] = array[0][i] + array[1][i];
           dp[1][i][2] = array[0][i + 1] + array[1][i];
        }

        solve();
        int answer = Integer.MAX_VALUE;
        for (int i = 1; i < m + 1; i++) {
            answer = Math.min(answer, Math.min(Math.min(dp[n - 1][i][0], dp[n - 1][i][1]), dp[n - 1][i][2]));
        }

        System.out.println(answer);
    }

    public static void solve() {
        for (int i = 2; i < n; i++) {
            for (int j = 1; j < m + 1; j++) {
                dp[i][j][0] = Math.min(dp[i - 1][j - 1][1], dp[i - 1][j - 1][2]) + array[i][j];
                dp[i][j][1] = Math.min(dp[i - 1][j][0], dp[i - 1][j][2]) + array[i][j];
                dp[i][j][2] = Math.min(dp[i - 1][j + 1][0], dp[i - 1][j + 1][1]) + array[i][j];
            }
        }
    }
}
