import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[][] map;
    static int[][] preSum;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        preSum = new int[n + 1][n + 1];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                preSum[i][j] = preSum[i-1][j] + preSum[i][j-1] - preSum[i-1][j-1] + map[i - 1][j - 1];
            }
        }

        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 1; k + j <= n && k + i <= n; k++) {
                    answer = Math.max(answer, calculateSum(i + 1, j + 1, k));
                }
            }
        }

        System.out.println(answer);
    }

    private static int calculateSum(int y, int x, int k) {
        return preSum[y + k - 1][x + k - 1] - preSum[y + k - 1][x - 1] - preSum[y - 1][x + k - 1] + preSum[y - 1][x - 1];
    }
}
