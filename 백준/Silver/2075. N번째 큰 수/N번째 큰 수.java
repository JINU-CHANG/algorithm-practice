import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][n];
        int[] array = new int[n];
        int[] yArray = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (i == n - 1) {
                    array[j] = map[i][j];
                    yArray[j] = n - 1;
                }
            }
        }

        int ans = 0;
        int idx;
        for (int i = 0; i < n; i++) {
            ans = Integer.MIN_VALUE;
            idx = 0;
            for (int j = 0; j < n; j++) {
                if (ans < array[j]) {
                    idx = j;
                    ans = array[j];
                }
            }

            if (yArray[idx] == 0) {
                array[idx] = Integer.MIN_VALUE;
            } else {
                yArray[idx] = yArray[idx] - 1;
                array[idx] = map[yArray[idx]][idx];
            }
        }

        System.out.println(ans);
    }
}
