import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Edge {
    int start;
    int end;
    int value;

    public Edge(int start, int end, int value) {
        this.start = start;
        this.end = end;
        this.value = value;
    }
}

public class Main {

    static int n, m, w;
    static int[] dist;
    static List<Edge> edges;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());
        for (; tc > 0; tc--) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            dist = new int[n + 1];
            Arrays.fill(dist, 987654321);
            edges = new ArrayList<>();
            for (; m > 0; m--) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());

                edges.add(new Edge(s, e, t));
                edges.add(new Edge(e, s, t));
            }

            for (; w > 0; w--) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                edges.add(new Edge(s, e, -t));
            }
            // 음수 사이클 존재하는지 확인
            if (bellman(edges.get(0).start)) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }

        System.out.println(sb);
    }

    private static boolean bellman(int start) {
        dist[start] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < edges.size(); j++) {
                Edge edge = edges.get(j);
                int current = edge.start;
                int next = edge.end;
                int cost = edge.value;

                if (dist[next] > dist[current] + cost) {
                    dist[next] = dist[current] + cost;

                    if (i == n - 1) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
