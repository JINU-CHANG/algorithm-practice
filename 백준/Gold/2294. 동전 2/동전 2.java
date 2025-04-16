import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] array = new int[n];
        int[][] dp = new int[n][k + 1];

        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        // 숫자 정렬 필요
        Arrays.sort(array);

        // dp 배열 초기화
        dp[0][0] = 0;
        for (int i = 1; i <= k; i++) {
            if (i % array[0] == 0) {
                dp[0][i] = i / array[0];
            } else {
                dp[0][i] = 100_001;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                // 지금 이 동전을 쓰냐, 쓰지 않냐
                if (j < array[i]) dp[i][j] = dp[i - 1][j];
                else dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - array[i]] + 1);
            }
        }

        if (dp[n - 1][k] == 100_001) {
            System.out.println(-1);
        } else {
            System.out.println(dp[n - 1][k]);
        }
    }
}
