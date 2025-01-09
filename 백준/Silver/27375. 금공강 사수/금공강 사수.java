import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

class Info implements Comparable<Info> {
    int w;
    int s;
    int e;

    public Info(int w, int s, int e) {
        this.w = w;
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(Info o) {
        if (this.w == o.w) {
            return this.s - o.s;
        }
        return this.w - o.w;
    }
}

public class Main {

    static List<Info> classes = new ArrayList<>();
    static boolean[] visited;
    static Map<Integer, LinkedList<Integer>> ends = new HashMap<>();
    static int n, k;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            classes.add(new Info(w, s, e));
        }

        for (int i = 0; i <= 5; i++) {
            ends.put(i, new LinkedList<>());
        }

        Collections.sort(classes);
        solve(0, 0);
        System.out.println(ans);
    }

    public static void solve(int idx, int credit) {
        if (credit == k) {
            ans++;
            return;
        }

        for (int i = idx; i < n; i++) {
            Info info = classes.get(i);
            int nCredit = credit + (info.e - info.s + 1);

            if (visited[i]) continue;
            if (info.w == 5) continue;
            if (!ends.get(info.w).isEmpty() && info.s <= ends.get(info.w).getLast()) continue;
            if (nCredit > k) continue;

            visited[i] = true;
            ends.get(info.w).add(info.e);

            solve(i, nCredit);

            visited[i] = false;
            ends.get(info.w).removeLast();
            }
        }
}
