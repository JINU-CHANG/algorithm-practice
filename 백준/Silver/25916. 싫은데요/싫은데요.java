import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int[] arr;
    static long[] sum;
    static long max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        sum = new long[n];
        sum[0] = arr[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + arr[i];
        }

        calculate();
        System.out.println(max);
    }

    public static void calculate() {
        for (int i = n - 1; i >= 0; i--) {
            if (sum[i] == m) {
                max = sum[i];
                return;
            }

            if (sum[i] < m) {
                max = Math.max(sum[i], max);
            }

            for (int j = i - 1; j >=0; j--) {
                long result = sum[i] - sum[j];

                if (result == m) {
                    max = result;
                    return;
                }

                if (result < m) {
                    max = Math.max(result, max);
                }

                if (result > m) break;
                if (j == 0) return;
            }
        }
    }
}
