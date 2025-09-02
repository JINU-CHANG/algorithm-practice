import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        boolean[][] floyd = new boolean[n][n];
        int[] plans = new int[m];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
               if (st.nextToken().equals("1")) {
                   floyd[i][j] = true;
               }

               if (i == j) {
                   floyd[i][j] = true;
               }
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            plans[i] = Integer.parseInt(st.nextToken());
        }

        for (int k = 0; k < n; k++) { // 중간
            for (int i = 0; i < n; i++) { // 출발
                for (int j = 0; j < n; j++) { // 도착
                    if (floyd[i][k] && floyd[k][j]) {
                        floyd[i][j] = true;
                    }
                }
            }
        }

        for (int i = 0; i < m -1; i++) {
            int start = plans[i] - 1;
            int end = plans[i + 1] - 1;
            if (!floyd[start][end]) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }
}
