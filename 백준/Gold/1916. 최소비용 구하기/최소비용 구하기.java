import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        List<List<int[]>> list = new ArrayList<>();
        int[] dij = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            list.add(new ArrayList<>());
        }

        Arrays.fill(dij, Integer.MAX_VALUE);

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list.get(start).add(new int[]{end, v});
            //list.get(end).add(new int[]{start, v});
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        Queue<int[]> queue = new PriorityQueue<>((a1, a2) -> a1[1] - a2[1]);

        dij[start] = 0;
        queue.add(new int[]{start, 0});

        while (!queue.isEmpty()) {
            int[] polled = queue.poll();
            if (polled[1] != dij[polled[0]]) continue;
            
            for (int[] arr : list.get(polled[0])) {
                int minValue = dij[arr[0]];
                int temp = polled[1] + arr[1];

                if (temp < minValue) {
                    dij[arr[0]] = temp;
                    if (arr[0] == end) continue;

                    queue.add(new int[]{arr[0], temp});
                }
            }
        }

        System.out.println(dij[end]);
    }
}
