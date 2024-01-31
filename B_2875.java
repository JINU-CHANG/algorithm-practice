import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2875 {
    static int N, M, K;
    static int ans;
    static int remaining;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        ans = N / 2;

        while(M-ans < 0) {
            ans -= 1;
        }

        remaining = (N - (ans*2)) + (M - ans);

        while(remaining < K) {
            if (ans == 0) {
                break;
            }
            ans -= 1;
            remaining += 3;
        }

        System.out.println(ans);
    }
}
