import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int[] dp = new int[n];
        int max = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                dp[0] = arr[0];
            } else if (i == 1) {
                dp[1] = arr[0] + arr[1];
            } else if (i == 2) {
                dp[2] = Math.max(arr[0] + arr[2], Math.max(dp[1], arr[1] + arr[2]));
            } else {
                dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i]));
            }

            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}

