import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] nums = new int[n];
        int[] dp = new int[1001];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            nums[i] = x;
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            for (int j = num - 1; j > 0; j--) {
                if (dp[j] >= 1) {
                    dp[num] = Math.max(dp[num], dp[j] + 1);
                    max = Math.max(max, dp[num]);
                }
            }

            if (dp[num] == 0) {
                dp[num] = 1;
            }

            max = Math.max(max, dp[num]);
        }

        System.out.println(max);
    }
}

