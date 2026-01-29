import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n, m, k;

        n = 0;
        m = Integer.parseInt(br.readLine());

        int[] arr = new int[m];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            n += arr[i];
        }

        k = Integer.parseInt(br.readLine());

        double a = 0;
        double b = 0;

        double temp = 1;
        for (int i = 0; i < k; i++) {
            temp *= k - i;
        }

        for (int x : arr) {
            a += combi(x, temp, k);
        }

        b += combi(n, temp, k);

        double result = a / b;
        System.out.println(result);
    }

    private static double combi(int n, double k, int cnt) {
        double temp = 1;
        for (int i = 0; i < cnt; i++) {
            temp *= n - i;
        }

        return temp / k;
    }
}
