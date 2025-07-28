import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] distances = new int[n - 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n - 1; i++) {
            distances[i] = Integer.parseInt(st.nextToken());
        }

        int[] oilPrice = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            oilPrice[i] = Integer.parseInt(st.nextToken());
        }

        long min = oilPrice[0];
        long sum = 0;
        for (int i = 0; i < n - 1; i++) {
            if (oilPrice[i] < min) {
                min = oilPrice[i];
            }

            sum += (min * distances[i]);
        }

        System.out.println(sum);
    }
}
