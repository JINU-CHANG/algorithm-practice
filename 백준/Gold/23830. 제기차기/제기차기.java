import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] scores;
    static int p, q, r;
    static long s;
    static int k = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        scores = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        p = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        s = Long.parseLong(st.nextToken());

        int result = search();

        if (k == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }

    public static int search() { // lower bound
        int left = 1;
        int right = 110_000;

        while (left < right) {
            int mid = (left + right) / 2;

            if (sum(mid) >= s) {
                right = mid;
                k = Math.min(k, right);
            } else {
                left = mid + 1;
            }
        }

        return right;
    }

    public static long sum(int k) {
        long sum = 0;
        for (int score : scores) {
            if (score > k + r) {
                score -= p;
            } else if (score < k) {
                score += q;
            }

            sum += score;
        }

        return sum;
    }
}
