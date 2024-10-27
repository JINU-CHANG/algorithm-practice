
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static long m;
    static long[] arrays;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arrays = new long[n];
        for (int i = 0; i < n; i++) {
            arrays[i] = Long.parseLong(st.nextToken());
        }

        solve();
        System.out.println(cnt);
    }

    public static void solve() {
        for (int i = 0; i < n - 1; i++) {
            if (Math.abs(arrays[i + 1] - arrays[i]) >= m)
                continue;
            if (check(i, i + 2)) {
                cnt++;
                i += 1;
            }
        }
    }

    public static boolean check(int a, int b) {
        int first = (int) Math.min((m - a), (b - m));
        int second = (int) Math.max((a + m), (m + b));

        return first > 0 || second > 0;
    }
}
