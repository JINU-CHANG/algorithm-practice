import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<List<Integer>> list;
    static boolean[] visited;
    static int[] listColors;
    static boolean answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < k; i++) {

            int v, e;
            st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            list = new ArrayList<>();
            visited = new boolean[v + 1];
            listColors = new int[v + 1];
            answer = true;

            for (int j = 0; j < v + 1; j++) {
                list.add(new ArrayList<>());
                listColors[j] = 1;
            }

            for (int j = 0; j < e; j++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                list.get(a).add(b);
                list.get(b).add(a);
            }

            for (int j = 1; j < v; j++) {
                dfs(j, listColors[j]);
            }

            if (answer) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    public static void dfs(int x, int color) {
        if (visited[x]) {
            if (listColors[x] != color) {
                answer = false;
            }

            return;
        }

        visited[x] = true;
        listColors[x] = color;

        for (Integer y : list.get(x)) {
            if (listColors[x] == 1) {
                dfs(y, 2);
            } else if (listColors[x] == 2) {
                dfs(y, 1);
            }
        }
    }
}

