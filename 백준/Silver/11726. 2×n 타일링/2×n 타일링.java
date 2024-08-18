import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static int[] dp;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];

        for (int i = 1; i <= 2; i++) {
            ans += dfs(i);
        }

        System.out.println(ans % 10_007);
    }

    public static int dfs(int x) {
        int cnt = 0;

        if (x == n) {
            return 1;
        }
        if (x > n) {
            return 0;
        }

        for (int i = 1; i <= 2; i++) {
            if (x + i < n + 1 && dp[x + i] != 0) cnt += dp[x + i] % 10007;
            else cnt += dfs(x + i) % 10007;
        }

        dp[x] = cnt;
        return cnt;
    }

}

