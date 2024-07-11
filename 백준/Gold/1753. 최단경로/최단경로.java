import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node {

    int v; // 간선
    int cost; // 가중치

    public Node(int v, int cost) {
        this.v = v;
        this.cost = cost;
    }
}
public class Main {

    static List<List<Node>> graph;
    static boolean[] visited;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        graph = new ArrayList<>(V + 1);
        dist = new int[V + 1];
        visited = new boolean[V + 1];

        for (int i = 0; i < V + 1; i++) {
            graph.add(new ArrayList<>());
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i < E + 1; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(u).add(new Node(v, w));
        }

        dijkstra(K);

        for (int i = 1; i < V + 1; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }
    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);

        queue.add(new Node(start, 0));
        dist[start] = 0;

        while (!queue.isEmpty()) {
            Node polled = queue.poll();

            if (!visited[polled.v]) {
                visited[polled.v] = true;
            }

            for (Node next : graph.get(polled.v)) {
                if (!visited[next.v] && dist[next.v] > polled.cost + next.cost) {
                    dist[next.v] = polled.cost + next.cost;
                    queue.add(new Node(next.v, dist[next.v]));
                }
            }
        }
    }
}
