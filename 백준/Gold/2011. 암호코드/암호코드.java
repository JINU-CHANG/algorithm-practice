import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static String password;
    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        password = br.readLine();

        dp = new long[password.length() + 1];
        solve();
        System.out.println(dp[password.length()] % 1000000);
    }

    public static void solve() {
        if (password.startsWith("0")) return;

        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            String substring = password.substring(i - 2, i);
            if (substring.endsWith("0")) {
                if ((substring.startsWith("1") || substring.startsWith("2"))) {
                    dp[i] = dp[i - 2] % 1000000;
                } else {
                    break;
                }
            } else {
                if (Integer.parseInt(substring) > 26 || Integer.parseInt(substring) < 10) {
                    dp[i] = dp[i - 1] % 1000000;
                } else {
                    dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000;
                }
            }
        }
    }
}
