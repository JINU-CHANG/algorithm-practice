import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

class Info {
    int x;
    int cnt;

    public Info(int x, int cnt) {
        this.x = x;
        this.cnt = cnt;
    }
}

public class Main {

    static int n, m;
    static int[] result;
    static int minResult = Integer.MAX_VALUE;
    static int minResultIdx;
    static Map<Integer, Set<Integer>> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        result = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            map.put(i, new HashSet<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            Set<Integer> setA = map.get(a);
            Set<Integer> setB = map.get(b);
            setA.add(b);
            setB.add(a);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) continue;
                result[i] += solve(i, j);
            }
        }

        for (int i = 1; i <= n; i++) {
            if (result[i] < minResult) {
                minResult = result[i];
                minResultIdx = i;
            }
        }

        System.out.println(minResultIdx);
    }

    public static int solve(int cIdx, int target) {
        Queue<Info> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1];

        visited[cIdx] = true;
        for (Integer i : map.get(cIdx)) {
            if (i == target) return 1;
            queue.add(new Info(i, 1));
            visited[i] = true;
        }

        while (!queue.isEmpty()) {
            Info polled = queue.poll();

            for (Integer i : map.get(polled.x)) {
                if (visited[i]) continue;

                if (i == target) return polled.cnt + 1;
                queue.add(new Info(i, polled.cnt + 1));
                visited[i] = true;
            }
        }

        return -1;
    }
}
