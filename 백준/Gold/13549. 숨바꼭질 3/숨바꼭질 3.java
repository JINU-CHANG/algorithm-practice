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
        System.out.print(bfs(n));
    }

    public static int bfs(int n) {
        int[] arr = new int[3];
        int[] dcnt = {0, 1, 1};
        Queue<Info> queue = new ArrayDeque<>();
        queue.add(new Info(n, 0));

        while (!queue.isEmpty()) {
            Info polled = queue.poll();
            if (polled.dx == k) {
                return polled.cnt;
            }
            arr[0] = polled.dx * 2;
            arr[1] = polled.dx - 1;
            arr[2] = polled.dx + 1;

            for (int i = 0; i < 3; i++) {
                if (arr[i] >= 0 && arr[i] <= 100_000 && !vistied[arr[i]]) {
                    queue.add(new Info(arr[i], dcnt[i] + polled.cnt));
                    vistied[arr[i]] = true;
                }
            }
        }
        
        return -1;
    }
}

