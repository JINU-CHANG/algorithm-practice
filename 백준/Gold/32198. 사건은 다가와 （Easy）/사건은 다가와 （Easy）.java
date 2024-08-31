import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
    int start;
    int end;

    public Node(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class QNode {
    int x;
    int t;
    int d;

    public QNode(int x, int t, int d) {
        this.x = x;
        this.t = t;
        this.d = d;
    }
}

public class Main {

    static int n, et;
    static int[] dx = {0, -1, 1}; // 0일때를 먼저 넣으면 최소거리 구해짐
    static int[] dd = {0, 1, 1};
    static ArrayList<Integer> ans = new ArrayList<>();
    static Map<Integer, Node> map = new HashMap<>();
    static int[][] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        et = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int t = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            map.put(t, new Node(s, e));
            et = Math.max(et, t);
        }

        memo = new int[et + 1][2001]; // -1000
        for (int i = 0; i <= et; i++) {
            Arrays.fill(memo[i], Integer.MAX_VALUE);
        }

        bfs();

        if (ans.isEmpty()) {
            System.out.println(-1);
        } else {
            Collections.sort(ans);
            System.out.println(ans.get(0));
        }
    }

    public static void bfs() {
        Queue<QNode> queue = new ArrayDeque<>();
        queue.add(new QNode(0, 0, 0));

        while (!queue.isEmpty()) {
            QNode polled = queue.poll();

            if (polled.t >= et) {
                break;
            }

            for (int i = 0; i < 3; i++) {
                int nt = polled.t + 1;
                int nx = polled.x + dx[i];
                int nd = polled.d + dd[i];

                if (map.containsKey(nt)) { // 바디뱅!
                    Node node = map.get(nt);
                    if ((node.start < nx && nx < node.end)) continue;
                }

                if (nx < -1000 || nx > 1000) continue;
                if (memo[nt][nx + 1000] <= nd) continue;
                if (nt == et) {
                    ans.add(nd);
                }

                queue.add(new QNode(nx, nt, nd));
                memo[nt][nx + 1000] = nd;
            }
        }
    }
}

