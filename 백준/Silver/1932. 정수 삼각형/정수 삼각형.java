import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][N];
        int[][] dp = new int[N][N + 2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][1] = arr[0][0];
        for (int i = 1; i < N; i++) {
            for (int j = 1; j <= i + 1; j++) {
                int x = dp[i - 1][j - 1] + arr[i][j - 1];
                int y = dp[i - 1][j] + arr[i][j - 1];

                dp[i][j] = Math.max(x, y);
            }
        }

        Arrays.sort(dp[N - 1]);
        System.out.println(dp[N - 1][N + 1]);
    }
}
