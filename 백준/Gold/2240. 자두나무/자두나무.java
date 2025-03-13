import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int max = Integer.MIN_VALUE;

        int[][] dp = new int[t][w + 1];
        int[] tArray = new int[t];

        for (int i = 0; i < t; i++) {
            tArray[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < w + 1; i++) {
            if (tArray[0] == 1 && i % 2 == 0) dp[0][i] = 1;
            if (tArray[0] == 2 && i % 2 != 0) dp[0][i] = 1;

            max = Math.max(max, dp[0][i]);
        }

        for (int i = 1; i < t; i++) {
            for (int j = 0; j < w + 1; j++) {
                int k = 0;
                if (tArray[i] == 1 && j % 2 == 0) k = 1;
                else if (tArray[i] == 2 && j % 2 != 0) k = 1;

                if (j == 0) dp[i][j] = dp[i - 1][j] + k;
                else dp[i][j] = Math.max(dp[i - 1][j - 1] + k, dp[i - 1][j] + k);
                max = Math.max(max, dp[i][j]);
            }
        }

        System.out.println(max);
    }
}
