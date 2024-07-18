import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        
        for (int i = 0; i < N; i++) {
            dfs(arr[i], new ArrayList<>());
        }
    }

    public static void dfs(int idx, List<Integer> ans) {
        ans.add(idx);

        if (ans.size() == M) {
            Set<Integer> set = new HashSet<>(ans);
            if (set.size() != M) return;

            StringBuilder sb = new StringBuilder();
            for (int an : ans) {
                sb.append(an).append(" ");
            }

            System.out.println(sb);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (arr[i] == idx) continue;

            dfs(arr[i], ans);
            ans.remove(ans.size() - 1);
        }
    }
}
