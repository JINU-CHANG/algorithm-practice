import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int ans;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dp = new int[m][27];

        solve();
        for (int i = 1; i <= 26; i++) {
            ans = (ans + dp[m - 1][i]) % 1_000_000_007;
        }

        System.out.println(ans);
    }

    public static void solve() {
        for (int i = 1; i <= 26; i++) {
            dp[0][i] = 1;
        }

        for (int i = 0; i < m - 1; i++) {
            for (int j = 1; j <= 26; j++) {
                for (int k = 1; k <= 26; k++) {
                    if (Math.abs(j - k) >= n) {
                        dp[i + 1][k] = (dp[i + 1][k] + dp[i][j]) % 1_000_000_007;
                    }
                }
            }
        }
    }
}
