import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static List<List<int[]>> list = new ArrayList<>();
    static int[] dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dist = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            list.add(new LinkedList<>());
        }

        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list.get(a).add(new int[]{b, v});
            list.get(b).add(new int[]{a, v});
        }

        dij();
        System.out.println(dist[n]);
    }

    private static void dij() {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.add(new int[]{1, 0});

        dist[1] = 0;

        while (!pq.isEmpty()) {
            int[] polled = pq.poll();

            if (dist[polled[0]] < polled[1]) {
                continue;
            }

            for (int[] next : list.get(polled[0])) {
                if (dist[next[0]] > polled[1] + next[1]) {
                    dist[next[0]] = polled[1] + next[1];
                    pq.add(new int[]{next[0], dist[next[0]]});
                }
            }
        }
    }
}
