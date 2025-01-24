import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Info {
    int a;
    int b;

    public Info(int a, int b) {
        this.a = a;
        this.b = b;
    }
}

public class Main {

    static int n;
    static int[] aArray;
    static int[] bArray;
    static Queue<Info> pq1 = new PriorityQueue<>((o1, o2) -> {
        if (o1.a == o2.a) {
            return o1.b - o2.b;
        }
        return o1.a - o2.a;
    });

    static Queue<Info> pq2 = new PriorityQueue<>((o1, o2) -> {
        if (o1.b == o2.b) {
            return o1.a - o2.a;
        }
        return o1.b - o2.b;
    });
    static long count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        aArray = new int[n];
        bArray = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            aArray[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            bArray[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            Info info = new Info(aArray[i], bArray[i]);
            pq1.add(info);
            pq2.add(info);
        }

        while (!pq1.isEmpty()) {
            Info polled2 = pq2.poll();
            Info polled1 = pq1.poll();

            while (polled1.b != polled2.b) {
                polled1.a += 30;
                count += 1;
                pq1.add(polled1);
                polled1 = pq1.poll();
            }

            if (polled1.a < polled1.b) {
                polled1.a += 30;
                count += 1;
                pq1.add(polled1);
                pq2.add(polled2);
            }
        }

        System.out.println(count);
    }
}
