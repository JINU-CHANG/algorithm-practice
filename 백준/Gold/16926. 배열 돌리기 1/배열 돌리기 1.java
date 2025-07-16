import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[][] array = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (; r > 0; r--) {
            int we = (m - 1);
            int ws = 0;
            int hs = 0;
            int he = (n - 1);

            while (true) {
                int before = 0;
                int now = 0;
                for (int i = we; i >= ws; i--) {
                    now = array[hs][i];
                    array[hs][i] = before;
                    before = now;
                }

                for (int i = (hs + 1); i <= he; i++) {
                    now = array[i][ws];
                    array[i][ws] = before;
                    before = now;
                }

                for (int i = (ws + 1); i <= we; i++) {
                    now = array[he][i];
                    array[he][i] = before;
                    before = now;
                }

                for (int i = (he - 1); i >= hs; i--) {
                    now = array[i][we];
                    array[i][we] = before;
                    before = now;
                }

                we--;
                ws++;
                he--;
                hs++;

                if (ws >= we || hs >= he) break;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(array[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
