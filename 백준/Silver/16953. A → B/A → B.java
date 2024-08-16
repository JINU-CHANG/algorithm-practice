import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Info {
    long x;
    int cnt;

    public Info(long x, int cnt) {
        this.x = x;
        this.cnt = cnt;
    }
}

public class Main {

    static long a, b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());

        if (!bfs(a)) {
            System.out.println(-1);
        }
    }

    public static boolean bfs(long x) {
        Queue<Info> queue = new ArrayDeque<>();
        queue.add(new Info(x, 0));

        while (!queue.isEmpty()) {
            Info polled = queue.poll();

            if (polled.x == b) {
                System.out.println(polled.cnt + 1);
                return true;
            }

            if (polled.x * 2 <= b) {
                queue.add(new Info(polled.x * 2, polled.cnt + 1));
            }

            if ((polled.x * 10) + 1 <= b) {
                queue.add(new Info((polled.x * 10) + 1, polled.cnt + 1));
            }
        }

        return false;
    }
}

