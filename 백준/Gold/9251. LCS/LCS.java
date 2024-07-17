import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String first = br.readLine();
        String second = br.readLine();

        int[][] dp = new int[second.length() + 1][first.length() + 1];

        for (int i = 1; i < second.length() + 1; i++) {
            for (int j = 1; j < first.length() + 1; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);

                if (first.charAt(j - 1) == second.charAt(i - 1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
            }
        }

        System.out.println(dp[second.length()][first.length()]);
    }
}
