import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] map;
    static int[] start;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n + 1][n + 1];
        start = new int[n / 2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i + 1][j + 1] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= n; i++) {
            dfs(i, 0);
        }

        System.out.println(ans);
    }

    private static void dfs(int x, int cnt) {
        if (cnt == n / 2) {
            int startResult = calculate(start);
            int linkResult = calculate(makeLink());
            //System.out.println(Arrays.toString(start));
            ans = Math.min(ans, Math.abs(startResult - linkResult));
            return;
        }

        for (int i = x; i <= n; i++) {
            start[cnt] = i;
            dfs(i + 1, cnt + 1);
        }
    }

    private static int[] makeLink() {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < start.length; i++) {
            set.add(start[i]);
        }

        List<Integer> link = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (set.contains(i)) continue;

            link.add(i);
        }

        int[] linkArr = new int[n/2];
        for (int i = 0; i < link.size(); i++) {
            linkArr[i] = link.get(i);
        }

        return linkArr;
    }

    private static int calculate(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i == j) continue;
                int y = arr[i];
                int x = arr[j];
                sum += map[y][x];
            }
        }
        return sum;
    }
}
