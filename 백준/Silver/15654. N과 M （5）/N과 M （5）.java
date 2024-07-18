import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int[] arr;
    static int[] ans;
    static boolean[] visited;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        ans = new int[M];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            dfs(i, 0);
        }

        System.out.println(sb);
    }

    public static void dfs(int idx, int cnt) {
        if (visited[idx]) return;

        ans[cnt] = arr[idx];
        visited[idx] = true;
        cnt++;

        if (cnt == M) {
            for (int an : ans) {
                sb.append(an).append(" ");
            }

            sb.append("\n");
            visited[idx] = false;
            return;
        }

        for (int i = 0; i < N; i++) {
            dfs(i, cnt);
        }

        visited[idx] = false;
    }
}
