import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int k;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        while (makeBottles(n) > k) {
            n++;
            count++;
        }

        System.out.println(count);
    }

    private static int makeBottles(int n) {
        int q = n / 2;
        int rSum = n % 2;

        while (q > 1) {
            rSum += q % 2;
            q = q / 2;
        }

        return (q + rSum);
    }
}
