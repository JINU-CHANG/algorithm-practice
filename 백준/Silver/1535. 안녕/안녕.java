import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] earr;
    static int[] harr;
    static int max = 0;
    static int n;
    static int energy = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        earr = new int[n];
        harr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            earr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            harr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            if (earr[i] < energy) {
                dfs(i, earr[i], harr[i]);
            }
        }

        System.out.println(max);
    }

    public static void dfs(int idx, int esum, int hsum) {
        for (int i = idx + 1; i < n; i++) {
            if (esum + earr[i] < energy) {
                dfs(i, esum + earr[i], hsum + harr[i]);
            } else {
                max = Math.max(max, hsum);
            }
        }

        max = Math.max(max, hsum);
    }
}

