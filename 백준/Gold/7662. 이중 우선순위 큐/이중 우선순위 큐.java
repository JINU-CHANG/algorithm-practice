import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (; t > 0; t--) {
            int n = Integer.parseInt(br.readLine());

            Map<Integer, Integer> map = new HashMap<>();
            PriorityQueue<Integer> minpq = new PriorityQueue<>(); // 최소값
            PriorityQueue<Integer> maxpq = new PriorityQueue<>((a, b) -> {
                if (a < b) return 1;
                else return -1;
            }); // 최대값

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                char c = st.nextToken().charAt(0);
                int x = Integer.parseInt(st.nextToken());

                if (c == 'I') {
                    minpq.add(x);
                    maxpq.add(x);

                    map.put(x, map.getOrDefault(x, 0) + 1);
                } else {
                    if (x == -1) {
                        delete(minpq, map);
                    } else {
                        delete(maxpq, map);
                    }
                }

                //System.out.println(minpq.peek() + " " + maxpq.peek());
            }

            while (!maxpq.isEmpty() && map.get(maxpq.peek()) == 0) {
                maxpq.poll();
            }
            while (!minpq.isEmpty() && map.get(minpq.peek()) == 0) {
                minpq.poll();
            }

            if (maxpq.isEmpty()) {
                sb.append("EMPTY").append("\n");
            } else {
                sb.append(maxpq.peek()).append(" ");
                sb.append(minpq.peek()).append("\n");
            }
        }

        System.out.println(sb);
    }

    private static void delete(PriorityQueue<Integer> pq, Map<Integer, Integer> map) {
        while (!pq.isEmpty() && map.get(pq.peek()) == 0) {
            pq.poll();
        }

        if (pq.isEmpty()) return;
        map.put(pq.peek(), map.get(pq.peek()) - 1);
        pq.poll();
    }
}
