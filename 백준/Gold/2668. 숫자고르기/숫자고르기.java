import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int[] arr;
    static boolean[] visited;
    static int start;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= n; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            start = i;
            if (!dfs(i)) visited[i] = false;
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (visited[i]) {
                ans++;
                sb.append(i).append("\n");
            }
        }

        System.out.println(ans);
        System.out.println(sb);
    }

    private static boolean dfs(int idx) {
        if (visited[arr[idx]] && start == arr[idx]) return true;
        else if (visited[arr[idx]] && start != arr[idx]) return false;

        visited[arr[idx]] = true;
        boolean result = dfs(arr[idx]);
        if (!result) {
            visited[arr[idx]] = false;
        }

        return result;
    }
}
