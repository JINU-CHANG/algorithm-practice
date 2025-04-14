import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = map[i][j];
                answer = Math.max(answer, sum);
                for (int k = 2; k + j <= n && k + i <= n; k++) {
                    sum = calculateSum(i, j, k, sum);
                    answer = Math.max(answer, sum);
                }
            }
        }

        System.out.println(answer);
    }

    private static int calculateSum(int y, int x, int k, int sum) {
        for (int i = x; i < x + k; i++) {
            sum += map[y + k - 1][i];
        }

        for (int i = y; i < y + k; i++) {
            sum += map[i][x + k - 1];
        }

        sum -= map[y + k - 1][x + k - 1];
        return sum;
    }
}
