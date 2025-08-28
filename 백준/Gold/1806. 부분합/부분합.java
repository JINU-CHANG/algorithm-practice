import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = arr[0];
        int ans = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;

        if (sum == s) {
            ans = 1;
            right++;
        }

        while (true) {
            if (right >= n - 1) break;

            int next = right + 1;

            if (arr[next] + sum >= s) {
                ans = Math.min(ans, (next - left) + 1);
                sum -= arr[left];
                left++;
            } else {
                sum += arr[next];
                right++;
            }
        }

        if (ans == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(ans);
        }
    }
}
