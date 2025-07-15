import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static boolean[][] train;
    static int n, m;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<String> set = new HashSet<>();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        train = new boolean[n + 1][21];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a == 1) {
                int c = Integer.parseInt(st.nextToken());
                first(b, c);
            } else if (a == 2) {
                int c = Integer.parseInt(st.nextToken());
                second(b, c);
            } else if (a == 3) {
                third(b);
            } else {
                fourth(b);
            }
        }

        for (int i = 1; i <= n; i++) {
            String string = Arrays.toString(train[i]);
            set.add(string);
        }

        System.out.println(set.size());
    }

    private static void first(int i, int x) {
        if (train[i][x]) return;
        train[i][x] = true; // 승차
    }

    private static void second(int i, int x) {
        if (!train[i][x]) return;
        train[i][x] = false; // 하차
    }

    private static void third(int i) {
        for (int j = 19; j >= 1; j--) {
            train[i][j + 1] = train[i][j];
            train[i][j] = false;
        }
    }

    private static void fourth(int i) {
        for (int j = 2; j <= 20; j++) {
            train[i][j - 1] = train[i][j];
            train[i][j] = false;
        }
    }
}
