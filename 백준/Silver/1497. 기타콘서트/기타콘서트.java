import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static String[] guitar;
    static String[] pick;
    static int max = 0;
    static int ans = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        guitar = new String[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            st.nextToken();
            String binary = st.nextToken().replace('Y', '1').replace('N', '0');
            guitar[i] = binary;
        }

        for (int i = 1; i <= n; i++) {
            pick = new String[i];
            back(-1, 0);
        }

        System.out.println(ans);
    }

    private static void back(int x, int count) {
        if (count == pick.length) {
            long sum = 0;

            for (int i = 0; i < pick.length; i++) {
                sum |= Long.parseLong(pick[i], 2);
            }

            int cnt = Long.bitCount(sum);

            if (max < cnt) {
                max = cnt;
                ans = pick.length;
            }
            return;
        }

        for (int i = x + 1; i < guitar.length; i++) {
            pick[count] = guitar[i];

            back(i, count + 1);
        }
    }
}
