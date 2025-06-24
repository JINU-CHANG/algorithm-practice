import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] Asum = new int[2_000_001];
    static int[] Bsum = new int[2_000_001];
    static int[] A;
    static int[] B;
    static int size;
    static int m, n;
    static int ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        A = new int[m];
        B = new int[n];

        for (int i = 0; i < m; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < n; i++) {
            B[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = i; j < (i + m) - 1; j++) {
                int k = j % m;
                sum += A[k];
                Asum[sum] += 1;
            }
        }

        int totalsum = 0;
        for (int i = 0; i < m; i++) {
            totalsum += A[i];
        }
        Asum[totalsum] += 1;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < (i + n) - 1; j++) {
                int k = j % n;
                sum += B[k];
                Bsum[sum] += 1;
            }
        }

        totalsum = 0;
        for (int i = 0; i < n; i++) {
            totalsum += B[i];
        }
        Bsum[totalsum] += 1;

        for (int i = 1; i < size; i++) {
            int a = i;
            int b = (size - i);

            ans += Asum[a] * Bsum[b];
        }

        ans += Asum[size];
        ans += Bsum[size];

        System.out.println(ans);
    }
}
