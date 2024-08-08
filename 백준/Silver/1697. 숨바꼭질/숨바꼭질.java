import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Info {
    int dx;
    int cnt;

    public Info(int dx, int cnt) {
        this.dx = dx;
        this.cnt = cnt;
    }
}

public class Main {

    static int n, k;
    static boolean[] vistied = new boolean[100_001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        if (n == k) {
            System.out.println(0);
        } else {
            bfs(n);
        }
    }

    public static void bfs(int n) {
        Queue<Info> queue = new ArrayDeque<>();
        queue.add(new Info(n, 0));

        while (!queue.isEmpty()) {
            Info polled = queue.poll();

            int first = polled.dx - 1;
            int second = polled.dx + 1;
            int third = polled.dx * 2;
            int dcnt = polled.cnt + 1;

            if (first == k || second == k || third == k) {
                System.out.println(dcnt);
                break;
            }

            if (first >=0 && first <= 100_000 && !vistied[first]) {
                queue.add(new Info(first, dcnt));
                vistied[first] = true;
            }

            if (second >=0 && second <= 100_000 && !vistied[second]) {
                queue.add(new Info(second, dcnt));
                vistied[second] = true;
            }

            if (third >=0 && third <= 100_000 && !vistied[third]) {
                queue.add(new Info(third, dcnt));
                vistied[third] = true;
            }
        }
    }
}

