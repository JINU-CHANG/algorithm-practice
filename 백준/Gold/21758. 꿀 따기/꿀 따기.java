import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] arr;
    static int[] pre;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        pre = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            pre[i + 1] = arr[i] + pre[i];
        }

        int sum = 0;
        for (int i = 1; i <= N - 2; i++) {
            sum = Math.max(sum, (pre[i + 1] - arr[0]) + (pre[N - 1] - pre[i]));
        }

        for (int i = 1; i <= N - 2; i++) {
            sum = Math.max(sum, (pre[N] - arr[0]) + (pre[N] - pre[i + 1]) - arr[i]);
        }

        for (int i = N - 2; i >= 1; i--) {
            sum = Math.max(sum, (pre[N] - arr[N - 1]) + (pre[i + 1] - arr[i]) - arr[i]);
        }

        System.out.println(sum);
    }
}

