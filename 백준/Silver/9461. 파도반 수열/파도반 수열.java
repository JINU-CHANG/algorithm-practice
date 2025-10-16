import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        long[] dp = new long[101];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;

        for (int i = 6; i < 101; i++) {
            dp[i] = dp[i - 1] + dp[(i - 6) + 1];
        }

        int T = Integer.parseInt(br.readLine());
        for (; T > 0; T--) {
            int x = Integer.parseInt(br.readLine());
            sb.append(dp[x]).append("\n");
        }

        System.out.println(sb);
    }
}
