import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
    int end;
    int time;

    public Node(int end, int time) {
        this.end = end;
        this.time = time;
    }

    @Override
    public int compareTo(Node o) {
        return this.time - o.time;
    }
}

public class Main {

    static int N, M, X;
    static List<List<Node>> graph;
    static boolean[] visited;
    static int[][] dis;
    static int[] ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>(N + 1);
        visited = new boolean[N + 1];
        dis = new int[N + 1][N + 1];
        ans = new int[N + 1];

        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] an : dis) {
            Arrays.fill(an, Integer.MAX_VALUE);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, t));
        }

        for (int i = 1; i < N + 1; i++) {
            dij(i);
            visited = new boolean[N + 1];
        }

        for (int i = 1; i < N + 1; i++) {
            ans[i] = dis[i][X] + dis[X][i];
        }

        Arrays.sort(ans);

        for (int i = ans.length - 1; i >= 0; i--) {
            if (ans[i] > 0) {
                System.out.println(ans[i]);
                break;
            }
        }
    }

    public static void dij(int start) {
        Queue<Node> pq = new PriorityQueue<>();

        for (Node node : graph.get(start)) {
            dis[start][node.end] = node.time;
            pq.add(new Node(node.end, node.time));
        }

        visited[start] = true;

        while(!pq.isEmpty()) {
            Node polled = pq.poll();

            if (!visited[polled.end]) {
                visited[polled.end] = true;
            }

            for (Node node : graph.get(polled.end)) {
                if (!visited[node.end] && dis[start][node.end] > polled.time + node.time) {
                    dis[start][node.end] = polled.time + node.time;
                    pq.add(new Node(node.end, dis[start][node.end]));
                }
            }
        }
    }
}
