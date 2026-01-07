import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

class Node {
    int n;
    int v;

    public Node(int n, int v) {
        this.n = n;
        this.v = v;
    }
}

class Main{

    static int[] dist;
    static int[] route;
    static Stack<Integer> routePrint = new Stack<>();
    static int N, M;
    static int start, end;
    static List<List<Node>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        dist = new int[N + 1];
        route = new int[N + 1];
        Arrays.fill(dist, 987654321);

        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list.get(s).add(new Node(e, v));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        dij(start);

        int temp = end;
        routePrint.push(temp);
        while (true) {
            if (temp == start) break;
            temp = route[temp];
            routePrint.push(temp);
        }

        sb.append(dist[end]).append("\n");
        sb.append(routePrint.size()).append("\n");

        while (!routePrint.isEmpty()) {
            sb.append(routePrint.pop()).append(" ");
        }

        System.out.println(sb);
    }

    private static void dij(int s) {
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.v - n2.v);

        pq.add(new Node(s, 0));
        dist[s] = 0;

        while (!pq.isEmpty()) {
            Node polled = pq.poll();

            if (dist[polled.n] < polled.v) continue;

            for (Node next : list.get(polled.n)) {
                if (dist[next.n] > polled.v + next.v) {
                    dist[next.n] = polled.v + next.v;
                    route[next.n] = polled.n;
                    pq.add(new Node(next.n, dist[next.n]));
                }
            }
        }
    }
}
