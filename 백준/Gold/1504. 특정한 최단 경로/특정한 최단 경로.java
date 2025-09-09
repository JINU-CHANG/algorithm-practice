import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node {
    int v;
    int cost;

    Node(int v, int cost) {
        this.v = v;
        this.cost = cost;
    }
}

public class Main {

    static int[] dist1;
    static int[] distV1;
    static int[] distV2;
    static int n, e;
    static int v1, v2;
    static final int INF = 200000000;
    static List<List<Node>> graph = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        dist1 = new int[n + 1];
        distV1 = new int[n + 1];
        distV2 = new int[n + 1];
        dij(1, dist1);
        dij(v1, distV1);
        dij(v2, distV2);

        int x = dist1[v1] + distV1[v2] + distV2[n];
        int y = dist1[v2] + distV2[v1] + distV1[n];

//        System.out.println(x + " " + y);
        int ans = 0;
        if (x >= INF && y >= INF) {
            ans = -1;
        } else {
            ans = Math.min(x, y);
        }

        System.out.println(ans);
    }

    private static void dij(int start, int[] dist) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        Arrays.fill(dist, INF);

        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node polled = pq.poll();

            for (Node next : graph.get(polled.v)) {
                if (dist[next.v] > polled.cost + next.cost) {
                    //System.out.println(polled.v + " " + next.v + " > " + (polled.cost + next.cost));
                    dist[next.v] = polled.cost + next.cost;
                    pq.add(new Node(next.v, dist[next.v]));
                }
            }
        }
    }
}
