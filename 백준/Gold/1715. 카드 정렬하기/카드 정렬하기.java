import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int n = Integer.parseInt(br.readLine());
        int ans = 0;

        for (; n > 0; n--) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();

            int count = a + b;
            ans += count;
            pq.add(count);
        }

        System.out.println(ans);
    }
}
