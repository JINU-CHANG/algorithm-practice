import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken());
        st = new StringTokenizer(br.readLine());

        long[] arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long left = 1;
        long right = 1_500_000_000;
        long mid;

        while (left <= right) {
            mid = (left + right) / 2;
            long sum = 0;

            for (int i = 0; i < N - 1; i++) {
                long d = arr[i + 1] - arr[i];

                sum += (mid * (mid + 1)/2);
                if (d < mid) sum -= (mid - d) * (mid - d + 1)/2;
            }

            sum += (mid * (mid + 1)/2);

            if (sum < K) left = mid + 1;
            else right = mid - 1;
        }

        System.out.println(left);
    }
}
