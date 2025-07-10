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

    static Queue<Integer> pq = new PriorityQueue<>();
    static int ws;
    static int we;
    static int sum = 0;
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
        
        initialize(list.get(0));
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
                sum += calculateSize();
                initialize(now);
            }
        }

        if (!pq.isEmpty()) {
            sum += calculateSize();
        }

        System.out.println(sum);
    }

    private static void initialize(Info info) {
        ws = info.s;
        we = info.e;
        pq = new PriorityQueue<>();
        pq.add(info.e);
    }
    
    private static int calculateSize() {
        int w = we - ws + 1;
        int h = pq.size();
        return w * h;
    }
}
