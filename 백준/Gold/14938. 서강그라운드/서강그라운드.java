import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main{

    static int n, m, r;
    static int[][] dist;
    static int[] items;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        items = new int[n + 1];
        dist = new int[n + 1][n + 1];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            items[i + 1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(dist[i], 987654321);
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            dist[n1][n2] = v;
            dist[n2][n1] = v;
        }

        for (int k = 1; k < n + 1; k++) {
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] =  dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        int answer = 0;
        for (int i = 1; i < n + 1; i++) {
            int sum = items[i];
            for (int j = 1; j < n + 1; j++) {
                if (i == j) continue;
                if (dist[i][j] <= m) sum += items[j];
            }

            answer = Math.max(answer, sum);
        }

        System.out.println(answer);
    }
}
