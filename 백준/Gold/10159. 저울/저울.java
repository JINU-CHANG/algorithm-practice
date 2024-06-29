import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<List<Integer>> lightList = new ArrayList<>();
    static List<List<Integer>> heavyList = new ArrayList<>();
    static List<Integer> ans = new ArrayList<>();
    static List<Boolean> visited = new ArrayList<>();
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < N + 1; i++) {
            lightList.add(new ArrayList<>());
            heavyList.add(new ArrayList<>());

            ans.add(0);
            visited.add(Boolean.FALSE);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int heavy = Integer.parseInt(st.nextToken());
            int light = Integer.parseInt(st.nextToken());

            lightList.get(heavy).add(light);
            heavyList.get(light).add(heavy);
        }

        for (int i = 1; i < N + 1; i++) {
            visitLight(i);
            reset(N);
            visitHeavy(i);
            reset(N);

            ans.set(i, N - cnt - 1);
            cnt = 0;
        }

        for (int i = 1; i < N + 1; i++) {
            System.out.println(ans.get(i));
        }
    }

    public static void visitLight(int start) {
        visited.set(start, Boolean.TRUE);

        for (Integer x : lightList.get(start)) {
            if (visited.get(x)) continue;
            visitLight(x);
            cnt++;
        }
    }

    public static void visitHeavy(int start) {
        visited.set(start, Boolean.TRUE);

        for (Integer x : heavyList.get(start)) {
            if (visited.get(x)) continue;
            visitHeavy(x);
            cnt++;
        }
    }

    public static void reset(int N) {
        for (int j = 0; j < N + 1; j++) {
            visited.set(j, Boolean.FALSE);
        }
    }
}
