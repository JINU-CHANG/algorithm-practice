import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static List<List<int[]>> list = new ArrayList<>();
    static int[] map; // 전달할 수 있는 최대값

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list.get(s).add(new int[]{e, v});
            list.get(e).add(new int[]{s, v});
        }

        map = new int[n + 1];
        Arrays.fill(map, Integer.MAX_VALUE);

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dij(start, end);
        System.out.println(map[end]);
    }

    private static void dij(int start, int end) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> -(o1[1] - o2[1]));
        pq.add(new int[]{start, Integer.MAX_VALUE});

        while (!pq.isEmpty()) {
            int[] polled = pq.poll();
            if (polled[0] == end) return;
            for (int[] arr : list.get(polled[0])) {
                int min = Math.min(polled[1], arr[1]);

                if (map[arr[0]] >= min && map[arr[0]] != Integer.MAX_VALUE) continue;

                map[arr[0]] = min;
                pq.add(new int[]{arr[0], min});
            }
        }
    }
}
