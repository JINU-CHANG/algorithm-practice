import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[][] weapons;
    static int[][] sortedWeapons;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        weapons = new int[n][m];
        sortedWeapons = new int[n][m];
        dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                weapons[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(solve());
    }

    public static int solve() {
        // 초기화
        for (int i = 0; i < m; i++) {
            dp[0][i] = weapons[0][i];
            sortedWeapons[0][i] = dp[0][i];
        }
        Arrays.sort(sortedWeapons[0]);

        // dp
        for (int i = 1; i < n; i++) {
            Arrays.sort(sortedWeapons[i - 1]);
            for (int j = 0; j < m; j++) {
                if (sortedWeapons[i - 1][0] == dp[i - 1][j]) {
                    dp[i][j] = weapons[i][j] + sortedWeapons[i - 1][1];
                } else {
                    dp[i][j] = weapons[i][j] + sortedWeapons[i - 1][0];
                }
                sortedWeapons[i][j] = dp[i][j];
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            ans = Math.min(ans, dp[n - 1][i]);
        }

        return ans;
    }
}
