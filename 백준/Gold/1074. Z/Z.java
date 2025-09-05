import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, R, C, count = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        int size = (int) Math.pow(2, N);
        solve(0, 0, size);
    }

    private static void solve(int r, int c, int size) {
        if (size == 1) {
            System.out.println(count);
            return;
        }

        int ns = size / 2;

        if (R < r + ns && C < c + ns) {
            // 1사분면
            solve(r, c, ns);
        } else if (R < r + ns && C >= c + ns) {
            // 2사분면
            count += ((size * size) / 4);
            solve(r, c + ns, ns);
        } else if (R >= r + ns && C < c + ns) {
            // 3사분면
            count += ((size * size) / 4) * 2;
            solve(r + ns, c, ns);
        } else {
            count += ((size * size) / 4) * 3;
            solve(r + ns, c + ns, ns);
        }
    }
}
