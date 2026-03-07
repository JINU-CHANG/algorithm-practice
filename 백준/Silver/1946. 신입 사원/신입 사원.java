import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());

        for (; T > 0; T--) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                arr[i] = new int[]{Integer.parseInt(st.nextToken()),
                        Integer.parseInt(st.nextToken())};
            }

            Arrays.sort(arr, (a1, a2) -> {
                return a1[0] - a2[0];
            });

            int min = Integer.MAX_VALUE;
            int ans = 0;
            for (int i = 0; i < n; i++) {
                if(arr[i][1] < min) {
                    ans++;
                    min = arr[i][1];
                }
            }

            sb.append(ans).append("\n");
//            System.out.println(Arrays.toString(arr[0]));
        }

        System.out.println(sb);
    }
}
