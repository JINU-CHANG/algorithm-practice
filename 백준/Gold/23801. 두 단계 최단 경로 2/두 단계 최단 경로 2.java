import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
    int cur;
    long cost;

    public Node(int cur, long cost) {
        this.cur = cur;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return (int) (this.cost - o.cost);
    }
}

public class Main {

    static int n, m;
    static List<List<Node>> list;
    static int[] pArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 1; i < m + 1; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list.get(u).add(new Node(v, w));
            list.get(v).add(new Node(u, w));
        }

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int z = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(br.readLine());

        pArr = new int[p];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < p; i++) {
            pArr[i] = Integer.parseInt(st.nextToken());
        }

        long[] x_distance = dji(x);
        long[] z_distance = dji(z);

        long min = Long.MAX_VALUE;
        for (int i = 0; i < p; i++) {
            if (x_distance[pArr[i]] == Long.MAX_VALUE || z_distance[pArr[i]] == Long.MAX_VALUE) continue;
            min = Math.min(min, x_distance[pArr[i]] + z_distance[pArr[i]]);
        }

        if (min == Long.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }
    }

    public static long[] dji(int x) {
        long[] distance = new long[n + 1];
        Arrays.fill(distance, Long.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(x, 0));

        while (!pq.isEmpty()) {
            Node polled = pq.poll();

            if (polled.cost > distance[polled.cur]) continue;

            for (Node next : list.get(polled.cur)) {
                if (polled.cost + next.cost < distance[next.cur]) {
                    distance[next.cur] = polled.cost + next.cost;
                    pq.add(new Node(next.cur, distance[next.cur]));
                }
            }
        }

        return distance;
    }
}
