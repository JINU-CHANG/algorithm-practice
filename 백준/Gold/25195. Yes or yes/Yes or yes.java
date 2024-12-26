import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n, m, s;
    static List<List<Integer>> list = new ArrayList<>();
    static boolean[] fan;
    static boolean way;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            list.get(start).add(end);
        }

        s = Integer.parseInt(br.readLine());
        fan = new boolean[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < s; i++) {
            int x = Integer.parseInt(st.nextToken());
            fan[x] = true;
        }

        dfs(1);

        if (!fan[1] && way) {
            System.out.println("yes");
        } else {
            System.out.println("Yes");
        }
    }

    public static void dfs(int start) {
        if (list.get(start).isEmpty()) {
            if (cnt == 0) way = true;
        }

        for (Integer end : list.get(start)) {
            if (fan[end]) cnt++;
            dfs(end);
        }

        if (fan[start]) cnt--;
    }
}
