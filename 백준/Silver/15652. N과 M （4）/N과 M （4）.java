import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[] answer;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        answer = new int[m];
        for (int i = 1; i <= n; i++) {
            answer[0] = i;
            dfs(i, 0);
        }

        System.out.println(sb);
    }

    private static void dfs(int start, int count) {
        if (count == m - 1) {
            for (int i : answer) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <= n; i++) {
            answer[count + 1] = i;
            dfs(i, count + 1);
        }
    }
}
