import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int t, n;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());

            for (int j = 1; j <= 3; j++) {
                ans += dfs(j);
            }

            sb.append(ans).append("\n");
            ans = 0;
        }

        System.out.println(sb);
    }

    public static int dfs(int x) {
        int cnt = 0;
        if (x == n) {
            return 1;
        }

        if (x > n) {
            return 0;
        }

        for (int i = 1; i <= 3; i++) {
            cnt += dfs(x + i);
        }

        return cnt;
    }

}
