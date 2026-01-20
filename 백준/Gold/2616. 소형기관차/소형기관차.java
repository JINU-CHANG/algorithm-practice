import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] peoples = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            peoples[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());

        // 누적합 구하기
        int[] sum = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            sum[i] = sum[i - 1] + peoples[i];
        }

        // dp 계산
        int[][] dp = new int[3][n + 1];

        // 초기화
        for (int i = m; i < n + 1; i++) {
            dp[0][i] = Math.max(dp[0][i - 1], sum[i] - sum[i - m]);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 1; i < 3; i++) {
            for (int j = (i + 1) * m; j < n + 1; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j - m] + sum[j] - sum[j - m]);
                max = Math.max(max, dp[i][j]);
            }
        }

        System.out.println(max);
    }
}
