import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static Queue<Long> pq = new PriorityQueue<>();
    static long ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            pq.add(Long.parseLong(st.nextToken()));
        }

        while (m != 0) {
            long polled1 = pq.poll();
            long polled2 = pq.poll();

            pq.add(polled1 + polled2);
            pq.add(polled1 + polled2);
            m--;
        }

        while (!pq.isEmpty()) {
            ans += pq.poll();
        }

        System.out.println(ans);
    }
}
