import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr;
        int n, m;
        int s = 0;
        int e = 0;
        int ans = 0;

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = arr[0];
        if (sum == m) {
            ans++;
        }
        while (true) {
            if (sum > m) {
                sum -= arr[s];
                s++;
            } else {
                e++;
                if (e == n) break;
                sum += arr[e];
            }

            if (sum == m) {
                ans++;
            }
        }

        System.out.println(ans);
    }
}
