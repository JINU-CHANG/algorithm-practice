import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n, m;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> ladderMap = new HashMap<>();
        Map<Integer, Integer> snakeMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            ladderMap.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            snakeMap.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        boolean[] visited = new boolean[101];

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{1, 0});

        while(!queue.isEmpty()) {
            int[] polled = queue.poll();
            int x = polled[0];
            int cnt = polled[1];

            for (int i = 1; i <= 6; i++) {
                int nx = x + i;
                if (visited[nx]) continue;
                if (ladderMap.containsKey(nx)) {
                    nx = ladderMap.get(nx);
                } else if (snakeMap.containsKey(nx)) {
                    nx = snakeMap.get(nx);
                }

                visited[nx] = true;

                if (nx == 100) {
                    System.out.println(cnt + 1);
                    return;
                }
                queue.add(new int[]{nx, cnt + 1});
            }
        }
    }
}
