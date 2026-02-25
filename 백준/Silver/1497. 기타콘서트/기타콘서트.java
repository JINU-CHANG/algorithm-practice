import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static long[] guitarMask;
    static long[] pick;
    static int max = 0;
    static int ans = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        guitarMask = new long[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            st.nextToken();
            String binary = st.nextToken();

            for(int j = 0; j < m; j++) {
                if (binary.charAt(j) == 'Y') {
                    guitarMask[i] |= (1L << j);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            pick = new long[i];
            back(-1, 0);
        }

        System.out.println(ans);
    }

    private static void back(int x, int count) {
        if (count == pick.length) {
            long sum = 0;
            for (int i = 0; i < pick.length; i++) {
                sum |= pick[i];
            }

            int cnt = Long.bitCount(sum);

            if (max < cnt) {
                max = cnt;
                ans = pick.length;
            }
            return;
        }

        for (int i = x + 1; i < guitarMask.length; i++) {
            pick[count] = guitarMask[i];

            back(i, count + 1);
        }
    }
}
