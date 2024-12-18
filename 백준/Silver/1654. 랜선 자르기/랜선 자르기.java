import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int k, n;
    static long[] lengths;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        lengths = new long[k];
        for (int i = 0; i < k; i++) {
            lengths[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(solve());
    }

    public static long solve() {
        long left = 1;
        long right = Integer.MAX_VALUE;

        while (left <= right) {
            long mid = (left + right) / 2;
            long count = count(mid);

            if (count >= n) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return right;
    }

    public static long count(long x) {
        long count = 0;
        for (Long length : lengths) {
            count += length / x;
        }

        return count;
    }
}
