import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class dot implements Comparable<dot> {
    int x;
    int y;

    public dot(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(dot o) {
        if (o.y == this.y) {
            return o.x - this.x;
        }
        return o.y - this.y;
    }
}

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        PriorityQueue<dot> pq = new PriorityQueue<>();

        int N = Integer.parseInt(st.nextToken());
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            pq.add(new dot(x, y));
        }

        while(!pq.isEmpty()) {
            dot polled1 = pq.poll();

            while(!pq.isEmpty()) {
                dot polled2 = pq.poll();

                if (polled1.x <= polled2.x) continue;
                if (polled2.y < polled1.x){
                    pq.add(polled2);
                    break;
                }

                polled1 = new dot(polled2.x, polled1.y);
            }

            cnt += polled1.y - polled1.x;
        }

        System.out.println(cnt);
    }
}
