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
    static int[] time = new int[100_001]; // 방문하는 최소시간을 저장한다.
    static int cnt = 0; // 방법의 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        if (n == k) {
            sb.append(0).append("\n").append(1);
        } else {
            bfs(n);
            sb.append(time[k]).append("\n").append(cnt);
        }

        System.out.println(sb);
    }

    public static void bfs(int n) {
        int[] arr = new int[3];
        int dcnt;
        Queue<Info> queue = new ArrayDeque<>();
        queue.add(new Info(n, 0));

        while (!queue.isEmpty()) {
            Info polled = queue.poll();

            arr[0] = polled.dx - 1;
            arr[1] = polled.dx + 1;
            arr[2] = polled.dx * 2;
            dcnt = polled.cnt + 1;

            for (int i = 0; i < 3; i++) {
                if (arr[i] < 0 || arr[i] > 100_000) continue; // 갈 수 없는 위치이면 큐에 넣지 않는다.
                if (dcnt > time[arr[i]] && time[arr[i]] != 0) continue; // X까지 가는데 더 오랜시간이 걸리면 큐에 넣지 않는다.

                if (arr[i] == k) {
                    while(!queue.isEmpty()) {
                        Info polled2 = queue.poll();

                        if (polled2.cnt != dcnt - 1) break;
                        if (polled2.dx - 1 == k || polled2.dx + 1 == k || polled2.dx * 2 == k) cnt++;
                    }
                    cnt++;
                    time[arr[i]] = dcnt;
                    return;
                }

                queue.add(new Info(arr[i], dcnt));
                time[arr[i]] = dcnt;
            }
        }
    }
}

