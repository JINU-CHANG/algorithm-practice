import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Info implements Comparable<Info> {
    int s;
    int e;

    Info(int s, int e) {
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(Info o) {
        if (this.s == o.s) {
            return o.e - this.e;
        }
        return this.s - o.s;
    }
}

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        List<Info> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            Info info = new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            list.add(info);
        }
        Collections.sort(list);

        Queue<Integer> pq = new PriorityQueue<>();
        int ws = list.get(0).s;
        int we = list.get(0).e;
        pq.add(list.get(0).e);
        int sum = 0;

        for (int i = 1; i < n; i++) {
            Info now = list.get(i);
            if (now.s <= we || now.s - we == 1) {
                we = Math.max(we, now.e);
                Integer peek = pq.peek();
                if (now.s > peek) {
                    pq.poll();
                }
                pq.add(now.e);
            } else {
                int w = we - ws + 1;
                int h = pq.size();
                sum += w * h;

                ws = now.s;
                we = now.e;
                pq = new PriorityQueue<>();
                pq.add(now.e);
            }
        }

        if (!pq.isEmpty()) {
            int w = we - ws + 1;
            int h = pq.size();
            sum += w * h;
        }

        System.out.println(sum);
    }
}
