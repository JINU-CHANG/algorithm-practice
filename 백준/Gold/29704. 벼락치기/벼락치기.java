import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Info {
    int d;
    int m;

    public Info(int d, int m) {
        this.d = d;
        this.m = m;
    }
}

public class Main {

    static int n, t;
    static List<Info> list = new ArrayList<>();
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        int moneySum = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            list.add(new Info(d, m));
            moneySum += m;
        }

        int ans = moneySum;
        dp = new int[n][t + 1];
        for (int j = 1; j < t + 1; j++) {
            if (j == list.get(0).d) dp[0][j] = moneySum - list.get(0).m;
            else dp[0][j] = moneySum;
            ans = Math.min(ans, dp[0][j]);
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < t + 1; j++) {
                int cd = list.get(i).d;
                int cm = list.get(i).m;

                if (j - cd < 0) dp[i][j] = dp[i - 1][j];
                else if (j == cd) dp[i][j] = Math.min(moneySum - cm, dp[i - 1][j]);
                else dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - cd] - cm);

                ans = Math.min(ans, dp[i][j]);
            }
        }

        System.out.println(ans);
    }
}
