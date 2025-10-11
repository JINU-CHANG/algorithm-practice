import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static StringBuffer sb = new StringBuffer();
    static int k, n;
    static boolean[] order = {true, false};
    static boolean[][] ladders;
    static boolean[] line;
    static char[] start;
    static char[] results;
    static boolean ans = false;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        k = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());
        start = new char[k];
        results = new char[k];
        ladders = new boolean[n][k - 1];
        line = new boolean[k - 1];
        String resultStr = br.readLine();
        for (int i = 0; i < k ; i++) {
            results[i] = resultStr.charAt(i);
            start[i] = resultStr.charAt(i);
        }

        Arrays.sort(start);

        for (int i = 0; i < n; i++) {
            String lineStr = br.readLine();
            boolean[] temp = ladders[i];
            for (int j = 0; j < k - 1; j++) {
                if (lineStr.charAt(j) == '-') {
                    temp[j] = true;
                }

                if (lineStr.charAt(j) == '?') {
                    line = temp;
                    break;
                }
            }
        }

        for (int i = 0; i < 2; i++) {
            line[0] = order[i];
            dfs(0, order[i]);
        }

        if (!ans) {
            for (int i = 0; i < k - 1; i++) {
                sb.append("x");
            }
        }

        System.out.println(sb);
    }

    private static void dfs(int cnt, boolean exist) {
        if (cnt == k - 2) {
            if (canResult()) {
                for (int i = 0; i < k - 1; i++) {
                    if (line[i]) sb.append("-");
                    else sb.append("*");
                }

                ans = true;
            }

            return;
        }

        if (exist) {
            line[cnt + 1] = false;
            dfs(cnt + 1, false);
        } else {
            for (int i = 0; i < 2; i++) {
                line[cnt + 1] = order[i];
                dfs(cnt + 1, order[i]);
            }
        }
    }

    private static boolean canResult() {
        for (int i = 0; i < k; i++) {
            int idx = i;

            for (int j = 0; j < n; j++) {
                boolean[] ladder = ladders[j];
                if (idx - 1 >= 0 && ladder[idx - 1]) idx = idx - 1;
                else if (idx + 1 <= k - 1 && ladder[idx]) idx = idx + 1;
            }

            if (results[idx] != start[i]) {
                return false;
            }
        }

        return true;
    }
}
